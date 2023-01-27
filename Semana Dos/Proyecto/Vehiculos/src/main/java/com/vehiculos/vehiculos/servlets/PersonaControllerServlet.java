package com.vehiculos.vehiculos.servlets;

import com.vehiculos.vehiculos.database.PersonaDTO;
import com.vehiculos.vehiculos.models.Persona;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/PersonaControllerServlet")
public class PersonaControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PersonaDTO personaDTO;

    @Resource(name="jdbc/vehiculos")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our person db util ... and pass in the conn pool / datasource
        try {
            personaDTO = new PersonaDTO(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing persons
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listPersonas(request, response);
                    break;

                case "ADD":
                    addPersona(request, response);
                    break;

                case "LOAD":
                    loadPersona(request, response);
                    break;

                case "UPDATE":
                    updatePersona(request, response);
                    break;

                case "DELETE":
                    deletePersona(request, response);
                    break;

                default:
                    listPersonas(request, response);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deletePersona(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person id from form data
        String idPersona = request.getParameter("id");

        // delete person from database
        personaDTO.deletePersona(idPersona);

        // send them back to "list persons" page
        listPersonas(request, response);
    }

    private void updatePersona(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person info from form data
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        // create a new person object
        Persona persona = new Persona(id, nombre, apellidos, telefono);

        // perform update on database
        personaDTO.updatePersona(persona);

        // send them back to the "list persons" page
        listPersonas(request, response);

    }

    private void loadPersona(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person id from form data
        String id = request.getParameter("id");

        // get person from database (db util)
        Persona objPersona = personaDTO.getPersona(id);

        // place person in the request attribute
        request.setAttribute("OBJ_PERSONA", objPersona);

        // send to jsp page: update-person-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-persona-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addPersona(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read person info from form data
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        // create a new person object
        Persona thePerson = new Persona(nombre, apellidos, telefono);

        // add the person to the database
        personaDTO.addPersona(thePerson);

        // send back to main page (the person list)
        listPersonas(request, response);
    }

    private void listPersonas(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get personas from db util
        List<Persona> personas = personaDTO.getPersonas();

        // add personas to the request
        request.setAttribute("PERSONAS_LIST", personas);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-personas.jsp");
        dispatcher.forward(request, response);
    }

}






