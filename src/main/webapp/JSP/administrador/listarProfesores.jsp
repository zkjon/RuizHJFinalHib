<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="eliminar tutor"/>
    </c:import>
    <style>
        .alumnos-lista {
            max-height: 13rem;
            overflow-y: auto;
            padding-right: 5px;
        }
    </style>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">Listado de profesores</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <table class="table-responsive table table-striped table-hover w-75">
        <thead class="table-primary">
        <tr>
            <th>Email</th>
            <th>Nombre Completo</th>
            <th>Alumnos en su Ciclo</th>
        </tr>
        </thead>
        <tbody class="table-danger">
        <c:forEach var="entry" items="${requestScope.tutores}">
            <tr>
                <td>${entry.key.email}</td>
                <c:set var="nombreCompleto" value="${entry.key.nombre} ${entry.key.apellidos}"/>
                <td>${entry.key.nombre != null ? nombreCompleto : "Este tutor aún no ha completado su registro"}</td>
                <td>
                    <div class="alumnos-lista">
                        <c:if test="${entry.value.size() > 0}">
                            <ul>
                                <c:forEach var="alumno" items="${entry.value}">
                                    <c:if test="${alumno.nombre != null}">
                                        <li>${alumno.nombre} ${alumno.apellidos} (${alumno.email})</li>
                                    </c:if>

                                    <c:if test="${alumno.nombre == null}">
                                        <li>Este alumno aún no a completado su registro</li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>

                        <c:if test="${entry.value.size() == 0}">
                            <p>No hay alumnos en su ciclo</p>
                        </c:if>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>