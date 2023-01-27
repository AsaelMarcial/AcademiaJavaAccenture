package com.vehiculos.vehiculos.database;

import com.vehiculos.vehiculos.models.Vehiculo;
import com.vehiculos.vehiculos.models.VehiculoList;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDTO {
    private DataSource dataSource;

    public VehiculoDTO(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<VehiculoList> getVehiculos() throws Exception {

        List<VehiculoList> vehiculos = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement with a join from persona ang get the persona nombre
            String sql = "select v.id, v.idPersona, v.marca, v.color, v.matricula, p.nombre from vehiculos v inner join personas p on v.idPersona = p.id order by v.id";
            //String sql = "select * from vehiculos order by id";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set (get the data from the database)
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                int idPersona = myRs.getInt("idPersona");
                String marca = myRs.getString("marca");
                String color = myRs.getString("color");
                String matricula = myRs.getString("matricula");
                String nombre = myRs.getString("nombre");

                // create new vehiculo object
                VehiculoList tempVehiculo = new VehiculoList(id, idPersona, marca, color, matricula, nombre);

                // add it to the list of vehiculos
                vehiculos.add(tempVehiculo);
            }


            return vehiculos;
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

    public void addVehiculo(Vehiculo vehiculo) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into vehiculos "
                    + "(idPersona, marca, color, matricula) "
                    + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the person
            myStmt.setInt(1, vehiculo.getIdPersona());
            myStmt.setString(2, vehiculo.getMarca());
            myStmt.setString(3, vehiculo.getColor());
            myStmt.setString(4, vehiculo.getMatricula());

            // execute sql insert
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public Vehiculo getVehiculo(String id) throws Exception {

        Vehiculo vehiculo = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int idVehiculo;

        try {
            // convert vehiculo id to int
            idVehiculo = Integer.parseInt(id);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected person
            String sql = "select * from vehiculos where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idVehiculo);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                int idPersona = myRs.getInt("idPersona");
                String marca = myRs.getString("marca");
                String color = myRs.getString("color");
                String matricula = myRs.getString("matricula");

                // use the idVehiculo during construction
                vehiculo = new Vehiculo(idVehiculo,idPersona, marca, color, matricula);
            }
            else {
                throw new Exception("Could not find vehicle id: " + idVehiculo);
            }

            return vehiculo;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updateVehiculo(Vehiculo vehiculo) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update vehiculos "
                    + "set idPersona=?, marca=?, color=?, matricula=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, vehiculo.getIdPersona());
            myStmt.setString(2, vehiculo.getMarca());
            myStmt.setString(3, vehiculo.getColor());
            myStmt.setString(4, vehiculo.getMatricula());
            myStmt.setInt(5, vehiculo.getId());


            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteVehiculo(String id) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert person id to int
            int idVehiculo = Integer.parseInt(id);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete person
            String sql = "delete from vehiculos where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idVehiculo);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }
}

