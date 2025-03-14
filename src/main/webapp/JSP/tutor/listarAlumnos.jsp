<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- Añadimos la librería para el formato -->
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="ver alumnos"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">mis alumnos</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >
    <table class="table-responsive table table-striped table-hover w-75">
        <thead class="table-info">
        <tr>
            <th>Alumno</th>
            <th class="text-center">Nota media</th>
            <th class="text-center">Nota media ponderada</th>
        </tr>
        </thead>
        <tbody class="table-danger">
        <c:forEach var="alumno" items="${requestScope.alumnos}" varStatus="status">
            <tr>
                <c:if test="${alumno.nombre != null}">
                    <td>${alumno.nombre} ${alumno.apellidos}</td>
                </c:if>

                <c:if test="${alumno.nombre == null}">
                    <td>El alumno con email <span class="fw-bold">${alumno.email}</span> aun no ha completado sus datos</td>
                </c:if>
                <td class="text-center fw-bold">
                    <c:set var="sumaNotas" value="0" />
                    <c:set var="contador" value="0" />

                    <c:forEach var="nota" items="${alumno.notas}">
                        <c:set var="sumaNotas" value="${sumaNotas + nota.nota}" />
                        <c:set var="contador" value="${contador + 1}" />
                    </c:forEach>

                    <c:choose>
                        <c:when test="${contador > 0}">
                            <fmt:formatNumber value="${sumaNotas / contador}" pattern="#,##0.00" />
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="0" pattern="#,##0.00" />
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="text-center fw-bold">
                    <fmt:formatNumber value="${alumno.notaPonderada}" pattern="#,##0.00" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
