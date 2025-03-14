<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="completar registro"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">Completa tus datos</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <form action="CompletarRegistro" method="post" class="bg-warning-subtle p-4 rounded-3 w-50">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Escribe tu nombre" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="apellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Escribe tus apellidos" required>
            </div>
        </div>

        <c:if test="${sessionScope.usuario.rol == 'ALUMNO'}">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="genero" class="form-label">Género</label>
                    <select class="form-select" id="genero" name="genero" required>
                        <c:forEach items="${requestScope.generos}" var="genero">
                            <option value="${genero}">${genero}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="${requestScope.fechaNacimiento}" required>
                </div>
            </div>
        </c:if>

        <div class="row">
            <div class="col-md-12 mb-3">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" class="form-control" id="dni" name="dni" placeholder="Ingresa tu DNI" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Crea una contraseña" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="password2" class="form-label">Confirmar contraseña</label>
                <input type="password" class="form-control" id="password2" name="password" placeholder="Repite tu contraseña" required>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" name="accion" value="completar" class="btn btn-warning">Completar</button>
        </div>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

<script src="${applicationScope.contexto}/JS/comprobarDatos.js"></script>

</body>
</html>
