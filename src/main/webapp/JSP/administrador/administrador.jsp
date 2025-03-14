<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="administrador"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">panel de control</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="FrontController" method="post">
        <button type="submit" name="accion" value="crear tutor" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Crear tutor</h5>
                <p class="card-text">Añade nuevos tutores al sistema.</p>
            </div>
        </button>
        <button type="submit" name="accion" value="eliminar profesor" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Eliminar Profesor</h5>
                <p class="card-text">Elimina profesores del sistema.</p>
            </div>
        </button>
        <button  type="submit" name="accion" value="listar profesores" class="card m-3" style="width: 18rem;">
            <div class="card-body text-center">
                <h5 class="card-title">Listado de profesores</h5>
                <p class="card-text">Mira el listado de profesores.</p>
            </div>
        </button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>