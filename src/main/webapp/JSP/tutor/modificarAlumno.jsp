<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="modificar nota"/>
    </c:import>
    <script src="${applicationScope.contexto}/JS/cambiarNota.js"></script>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">modifica y califica a tus alumnos</h1>
<div id="alert-container" class="alert-container position-fixed top-0 end-0 p-3"></div>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >

    <form action="AjaxController" method="post" class="w-100">
        <table class="table-responsive table table-striped table-hover">
            <thead class="table-info">
            <tr>
                <th>Alumno</th>
                <c:forEach var="nota" items="${requestScope.alumnos.get(0).notas}">
                    <th>${nota.modulo.abreviatura}</th>
                </c:forEach>
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
                    <c:forEach var="nota" items="${alumno.notas}">
                        <td>
                            <input type="number" id="nota-${alumno.idUsuario}-${nota.modulo.idModulo}"
                                   value="${nota.nota}" class="form-control text-center" min="0" max="10" required
                                   onchange="cambiarNota(event, ${alumno.idUsuario}, ${nota.modulo.idModulo})">
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
