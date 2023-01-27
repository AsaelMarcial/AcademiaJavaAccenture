package com.vehiculos.vehiculos.servlets;

import com.vehiculos.vehiculos.database.VehiculoDTO;
import com.vehiculos.vehiculos.models.Vehiculo;
import com.vehiculos.vehiculos.models.VehiculoList;

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

@WebServlet("/VehiculoControllerServlet")
public class VehiculoControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VehiculoDTO vehiculoDTO;

    @Resource(name="jdbc/vehiculos")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our person db util ... and pass in the conn pool / datasource
        try {
            vehiculoDTO = new VehiculoDTO(dataSource);
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
                    listVehiculos(request, response);
                    break;

                case "ADD":
                    addVehiculo(request, response);
                    break;

                case "LOAD":
                    loadVehiculo(request, response);
                    break;

                case "UPDATE":
                    updateVehiculo(request, response);
                    break;

                case "DELETE":
                    deleteVehiculo(request, response);
                    break;

                default:
                    listVehiculos(request, response);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person id from form data
        String idVehiculo = request.getParameter("id");

        // delete person from database
        vehiculoDTO.deleteVehiculo(idVehiculo);

        // send them back to "list persons" page
        listVehiculos(request, response);
    }

    private void updateVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person info from form data
        int id = Integer.parseInt(request.getParameter("id"));
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        String marca = request.getParameter("marca");
        String color = request.getParameter("color");
        String matricula = request.getParameter("matricula");

        // create a new person object
        Vehiculo vehiculo = new Vehiculo(id, idPersona, marca, color, matricula);

        // perform update on database
        vehiculoDTO.updateVehiculo(vehiculo);

        // send them back to the "list persons" page
        listVehiculos(request, response);

    }

    private void loadVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read person id from form data
        String id = request.getParameter("id");

        // get person from database (db util)
        Vehiculo objVehiculo = vehiculoDTO.getVehiculo(id);

        // place person in the request attribute
        request.setAttribute("OBJ_VEHICULO", objVehiculo);

        // send to jsp page: update-person-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-vehiculo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addVehiculo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read person info from form data
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        String marca = request.getParameter("marca");
        String color = request.getParameter("color");
        String matricula = request.getParameter("matricula");

        // create a new person object
        Vehiculo vehiculo = new Vehiculo(idPersona ,marca, color, matricula);

        // add the person to the database
        vehiculoDTO.addVehiculo(vehiculo);

        // send back to main page (the person list)
        listVehiculos(request, response);
    }

    private void listVehiculos(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get vehiculos from db util
        List<VehiculoList> vehiculos = vehiculoDTO.getVehiculos();

        // add vehiculos to the request
        request.setAttribute("VEHICULOS_LIST", vehiculos);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-vehiculos.jsp");
        dispatcher.forward(request, response);
    }

}







