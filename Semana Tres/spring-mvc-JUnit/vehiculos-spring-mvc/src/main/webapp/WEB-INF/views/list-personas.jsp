<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <img src="https://companieslogo.com/img/orig/ACN-cce5b411.png?t=1633439499" width="50" style="margin:0px 10px">
        <a class="navbar-brand" href="../index.jsp">Java Academy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="list">Personas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../VehiculoControllerServlet">Vehiculos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<body>

<div id="wrapper" style="margin: 40px 40px">
    <div id="header">
        <h2>LISTA DE PERSONAS CON HIBERNATE ORM</h2>
    </div>
</div>

<div id="container" style="margin: 0px 40px">

    <div id="content">

        <!-- put new button: Add Persona -->

        <input type="button" class="btn btn-primary" value="Add Persona"
               onclick="window.location.href='addPersonaForm'; return false;"
               class="add-button"
        />

        <!--  add our html table here -->

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Telefono</th>
                <th>Acciones</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempPersonas" items="${personas}">

                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/personas/updatePersona">
                    <c:param name="id" value="${tempPersonas.id}" />
                </c:url>

                <!-- construct an "delete" link with customer id -->
                <c:url var="deleteLink" value="/personas/delete">
                    <c:param name="id" value="${tempPersonas.id}" />
                </c:url>

                <tr>
                    <td> ${tempPersonas.id} </td>
                    <td> ${tempPersonas.nombre} </td>
                    <td> ${tempPersonas.apellidos} </td>
                    <td> ${tempPersonas.telefono} </td>

                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this persona it will also delete all his vehicles?'))) return false">Delete</a>
                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>








