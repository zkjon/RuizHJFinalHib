<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="ver notas"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">mis notas</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >
        <table class="table-responsive table table-striped table-hover w-75">
            <thead class="table-info">
                <tr>
                    <c:forEach var="nota" items="${sessionScope.usuario.notas}">
                        <th class="text-center">${nota.modulo.abreviatura}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody class="table-danger">
                <tr>
                    <c:forEach var="nota" items="${sessionScope.usuario.notas}">
                        <td>
                            <input type="text" disabled readonly value="${nota.nota}" class="form-control text-center">
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>