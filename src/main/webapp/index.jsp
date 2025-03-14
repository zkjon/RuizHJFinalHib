<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="INC/head.jsp">
        <c:param name="title" value="inicio"/>
    </c:import>
</head>

<body>
    <c:import url="INC/header.jsp"/>

    <main class="container-fluid d-flex justify-content-center align-items-center" style="height: 80vh;">
        <div class="container bg-white p-4 rounded-3 shadow">
            <h1 class="text-center text-warning-emphasis">Aplicación de gestión escolar</h1>
            <p class="text-center text-warning h4">Crea, personaliza, elimina y consulta información sobre tu escuela</p>
        </div>
    </main>

    <c:import url="INC/footer.jsp"/>
</body>
</html>
