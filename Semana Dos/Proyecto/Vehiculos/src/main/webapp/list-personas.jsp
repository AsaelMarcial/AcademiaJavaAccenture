<%@ page import="java.util.*, com.vehiculos.vehiculos.models.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Personas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <img src="https://scontent-mty2-1.xx.fbcdn.net/v/t39.30808-6/301885698_503442548450926_7310079897676107044_n.png?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=gNuC3fTPbywAX_xcUUh&_nc_ht=scontent-mty2-1.xx&oh=00_AfDbH125Y6TzV3_DOiREhdU4uH4VL2TmkT36zTgoi4yykg&oe=63D77004" width="50" style="margin:0px 10px">
        <a class="navbar-brand" href="index.jsp">Java Academy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="PersonaControllerServlet">Personas</a>
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
    List<Persona> personas =
            (List<Persona>) request.getAttribute("PERSONAS_LIST");
%>

<body>

<div id="container" style="margin: 40px 40px">
    <button type="button" class="btn btn-primary" onclick="window.location.href='add-persona-form.jsp'; return false;"
            class="add-person-button">
        Nueva persona
    </button>
    <div id="content">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Telefono</th>
                <th>Acciones</th>
            </tr>
            </thead>
                <tbody>
                <tr>
                   <% for (Persona tempPersona : personas) { %>

                <tr>
                    <td> <%= tempPersona.getId() %> </td>
                    <td> <%= tempPersona.getNombre() %> </td>
                    <td> <%= tempPersona.getApellidos() %> </td>
                    <td> <%= tempPersona.getTelefono() %> </td>
                <td>
                    <a class="btn btn-warning" href="PersonaControllerServlet?command=LOAD&id=<%= tempPersona.getId() %>">Editar</a>
                    <a class="btn btn-danger" href="PersonaControllerServlet?command=DELETE&id=<%= tempPersona.getId() %>"
                       onclick="if (!(confirm('Estas seguro que deseas eliminar a <%= tempPersona.getNombre() %>?, Esta accion eliminara de manera permanente todos sus vehiculos relacionados'))) return false">
                        Eliminar</a>
                </td>

                <% } %>

            </tbody>
        </table>
    </div>
</div>


</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>








