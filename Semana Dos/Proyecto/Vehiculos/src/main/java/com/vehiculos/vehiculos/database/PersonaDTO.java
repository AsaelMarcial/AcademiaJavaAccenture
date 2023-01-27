package com.vehiculos.vehiculos.database;

import com.vehiculos.vehiculos.models.Persona;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDTO {

    private DataSource dataSource;

    public PersonaDTO(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Persona> getPersonas() throws Exception {

        List<Persona> personas = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
            String sql = "select * from personas order by apellidos";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String nombre = myRs.getString("nombre");
                String apellidos = myRs.getString("apellidos");
                String telefono = myRs.getString("telefono");

                // create new person object
                Persona tempPerson = new Persona(id, nombre, apellidos, telefono);

                // add it to the list of persons
                personas.add(tempPerson);
            }

            return personas;
        }
        finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addPersona(Persona persona) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into personas "
                    + "(nombre, apellidos, telefono) "
                    + "values (?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the person
            myStmt.setString(1, persona.getNombre());
            myStmt.setString(2, persona.getApellidos());
            myStmt.setString(3, persona.getTelefono());

            // execute sql insert
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public Persona getPersona(String id) throws Exception {

        Persona persona = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int idPersona;

        try {
            // convert person id to int
            idPersona = Integer.parseInt(id);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected person
            String sql = "select * from personas where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idPersona);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String nombre = myRs.getString("nombre");
                String apellidos = myRs.getString("apellidos");
                String telefono = myRs.getString("telefono");

                // use the idPersona during construction
                persona = new Persona(idPersona, nombre, apellidos, telefono);
            }
            else {
                throw new Exception("Could not find person id: " + idPersona);
            }

            return persona;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updatePersona(Persona persona) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update personas "
                    + "set nombre=?, apellidos=?, telefono=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, persona.getNombre());
            myStmt.setString(2, persona.getApellidos());
            myStmt.setString(3, persona.getTelefono());
            myStmt.setInt(4, persona.getId());

            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deletePersona(String id) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert person id to int
            int idPersona = Integer.parseInt(id);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete person
            String sql = "delete from personas where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idPersona);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }
}

