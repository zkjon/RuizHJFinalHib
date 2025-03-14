<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="meta.inc"/>
<fmt:setLocale value="es_ES" />
<title>${param.titulo}</title>

<!-- Bootstrap 5 CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" />

<!-- Font Awesome (Opcional para íconos) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>

<!-- Bootstrap Bundle (incluye Popper.js) -->
<script src="${pageContext.request.contextPath}/JS/bootstrap.bundle.js"></script>
<style>
    body{
        background-color: #000;
    }
</style>