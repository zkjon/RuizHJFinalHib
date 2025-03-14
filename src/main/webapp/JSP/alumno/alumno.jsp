<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="alumno"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">pagina de alumno</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="FrontController" method="post">
        <button type="submit" name="accion" value="actualizar datos" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Cambiar mis datos</h5>
                <p class="card-text">Cambia mis datos personales</p>
            </div>
        </button>
        <button type="submit" name="accion" value="ver notas" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Ver mis notas</h5>
                <p class="card-text">Consulta las calificaciones obtenidas.</p>
            </div>
        </button>
        <button type="submit" name="accion" value="ver modulos" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Ver mis módulos</h5>
                <p class="card-text">Consulta los módulos con información completa.</p>
            </div>
        </button>
    </form>


</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>