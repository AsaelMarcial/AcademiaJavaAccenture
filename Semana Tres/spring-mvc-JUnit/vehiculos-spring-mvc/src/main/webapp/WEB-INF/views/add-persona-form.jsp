<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container" style="margin: 10px 40px">
    <h3>Save Customer</h3>

    <form:form action="savePersona" modelAttribute="persona" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Nombre:</label></td>
                <td><form:input path="nombre" /></td>
            </tr>

            <tr>
                <td><label>Apellidos:</label></td>
                <td><form:input path="apellidos" /></td>
            </tr>

            <tr>
                <td><label>Telefono:</label></td>
                <td><form:input path="telefono" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Guardar" class="btn btn-primary" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>

    <div style="clear; both;"></div>

    <p style="margin: 20px">
        <a href="${pageContext.request.contextPath}/personas/list">Back to List</a>
    </p>

</div>

</body>
</html>