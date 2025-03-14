<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="500"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">Error 500</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <div class="container text-center py-5">
        <h1 class="display-1 fw-bold text-danger">500</h1>
        <p class="lead">Hubo iun fallo en el servidor, por favor, disculpe las molestias</p>
    </div>
</main>
<c:import url="/INC/footer.jsp"/>

</body>
</html>
