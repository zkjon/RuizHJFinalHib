<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="tutor"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">panel de control</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="FrontController" method="post">
        <button type="submit" name="accion" value="crear alumno" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Crear alumnos</h5>
                <p class="card-text">Añade nuevos alumnos al modulo.</p>
            </div>
        </button>
        <button type="submit" name="accion" value="modificar alumno" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Modificar e introducir notas</h5>
                <p class="card-text">Modifica las notas de un alumno.</p>
            </div>
        </button>
        <button type="submit" name="accion" value="eliminar alumno" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Eliminar alumnos</h5>
                <p class="card-text">Elimina alumnos y todos sus datos.</p>
            </div>
        </button>
        <button  type="submit" name="accion" value="listar alumnos" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Listado de alumnos</h5>
                <p class="card-text">Ver las nota media y media ponderada de todos los alumnos.</p>
            </div>
        </button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>