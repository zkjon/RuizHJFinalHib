<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="ver modulos"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">mis modulos</h1>
<main class="d-flex justify-content-center align-items-center mt-1 p-3 align-middle" >
    <table class="table-responsive table table-striped table-hover w-75">
        <thead class="table-info">
        <tr>
            <th>Tutor</th>
            <th>Familia</th>
            <th>Curso</th>
            <th>Módulo</th>
        </tr>
        </thead>
        <tbody class="table-danger">
        <c:forEach var="nota" items="${sessionScope.usuario.notas}">
            <tr>
                <td>${requestScope.tutor}</td>
                <td>${nota.modulo.familia.denominacion != null ? nota.modulo.familia.denominacion : "No pertenece a ninguna familia"}</td>
                <td>${nota.modulo.curso}</td>
                <td>${nota.modulo.nombre}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>