<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="realizado"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-success">Enhorabuena</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >
    <div class="text-center fs-3 bg-success text-white p-3 rounded-3 shadow-lg w-75">
        ${requestScope.mensaje}
    </div>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>