<%@ page import="java.util.*, com.academy.springmvc.*" %>
<%@ page import="com.academy.springmvc.entities.Vehiculos" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Vehiculos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <img src="https://companieslogo.com/img/orig/ACN-cce5b411.png?t=1633439499" width="50" style="margin:0px 10px">
        <a class="navbar-brand" href="index.jsp">Java Academy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="personas/list">Personas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="VehiculoControllerServlet">Vehiculos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%
    // get the persons from the request object (sent by servlet)
    List<Vehiculos> vehiculos =
            (List<Vehiculos>) request.getAttribute("VEHICULOS_LIST");
%>

<body>

<div id="container" style="margin: 40px 40px">
    <div id="header">
        <h2>LISTA DE VEHICULOS CON JDBC</h2>
    </div>
    <button type="button" class="btn btn-primary" onclick="window.location.href='add-vehiculo-form.jsp'; return false;"
            class="add-person-button" disabled>
        Nuevo vehiculo
    </button>
    <div id="content">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Duenio</th>
                <th>Marca</th>
                <th>Color</th>
                <th>Matricula</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                    <% for (Vehiculos tempVehiculo : vehiculos) { %>

            <tr>
                <td> <%= tempVehiculo.getIdPersona() %> </td>
                <td> <%= tempVehiculo.getMarca() %> </td>
                <td> <%= tempVehiculo.getColor() %> </td>
                <td> <%= tempVehiculo.getMatricula() %> </td>

                    <% } %>

            </tbody>
        </table>
    </div>
</div>


</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>















