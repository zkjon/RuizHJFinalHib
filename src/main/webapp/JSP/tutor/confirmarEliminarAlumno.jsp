<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="confirmar eliminacion"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">Confirmar Eliminación</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <form action="TutorController" method="post" class="bg-warning-subtle p-4 rounded-3 w-50">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="ID" class="form-label">ID</label>
                <input type="text" class="form-control" id="ID" value="${sessionScope.alumno.idUsuario}" readonly required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" value="${sessionScope.alumno.email}" readonly required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" value="${sessionScope.alumno.nombre}" readonly required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="apellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="apellidos" value="${sessionScope.alumno.apellidos}" readonly required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="fecha" class="form-label">Fecha de Nacimiento</label>
                <input type="text" class="form-control" id="fecha" value="${sessionScope.alumno.fechaNacimiento}" readonly required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="genero" class="form-label">Género</label>
                <input type="text" class="form-control" id="genero" value="${sessionScope.alumno.genero}" readonly required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" class="form-control" id="dni" value="${sessionScope.alumno.dni}" readonly required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="ciclo" class="form-label">Ciclo</label>
                <input type="text" class="form-control" id="ciclo" value="${sessionScope.alumno.ciclo.abreviatura}-${sessionScope.alumno.ciclo.nombre}" readonly required>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" name="accion" value="eliminar alumno confirmado" class="btn btn-warning">Eliminar Definitivamente</button>
        </div>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
