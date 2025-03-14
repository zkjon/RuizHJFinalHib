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
<h1 class="fw-bold text-center mb-4 mt-5 text-white">elimina un tutor</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="AdministradorController" method="post" class="bg-warning-subtle p-3 rounded-3 w-50">

        <table class="table-responsive table table-striped table-hover">
            <thead class="table-info">
                <tr>
                    <th>Selecciona</th>
                    <th>Nombre y Apellidos</th>
                    <th>Ciclo</th>
                </tr>
            </thead>
            <tbody class="table-danger">
                <c:forEach var="tutor" items="${requestScope.tutores}" varStatus="status">
                    <tr>
                        <td>
                            <input type="radio" name="tutor" value="${tutor.idUsuario}" ${status.index == 0 ? 'checked' : ''}>
                        </td>
                        <c:if test="${tutor.nombre != null}">
                            <td>${tutor.nombre} ${tutor.apellidos}</td>
                        </c:if>

                        <c:if test="${tutor.nombre == null}">
                            <td>El tutor con email <span class="fw-bold">${tutor.email}</span> aun no ha completado sus datos</td>
                        </c:if>
                        <td>${tutor.ciclo.abreviatura}-${tutor.ciclo.nombre}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

        <button type="submit" name="accion" value="eliminar tutor" class="btn btn-warning">eliminar tutor</button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>