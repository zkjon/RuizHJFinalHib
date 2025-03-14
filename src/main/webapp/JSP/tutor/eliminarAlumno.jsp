<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="eliminar tutor"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">elimina tus alumnos</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="TutorController" method="post" class="bg-warning-subtle p-3 rounded-3 w-50">

        <table class="table-responsive table table-striped table-hover">
            <thead class="table-info">
            <tr>
                <th>selecciona</th>
                <th>nombre y apellidos (email)</th>
            </tr>
            </thead>
            <tbody class="table-danger">
            <c:forEach var="alumno" items="${requestScope.alumnos}" varStatus="status">
                <tr>
                    <td>
                        <input type="radio" name="alumno" value="${alumno.idUsuario}" ${status.index == 0 ? 'checked' : ''}>
                    </td>
                    <c:if test="${alumno.nombre != null}">
                        <td>${alumno.nombre} ${alumno.apellidos} (${alumno.email})</td>
                    </c:if>

                    <c:if test="${alumno.nombre == null}">
                        <td>El alumno no ha completado sus datos (${alumno.email})</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <button type="submit" name="accion" value="eliminar alumno" class="btn btn-warning">eliminar alumno</button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>