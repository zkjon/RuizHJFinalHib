<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="crear alumno"/>
    </c:import>
    <script src="${applicationScope.contexto}/JS/comprobarCorreo.js">
    </script>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">agrega un nuevo alumno a tu ciclo</h1>

<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle" >
    <div id="alert-container" class="alert-container position-fixed end-0 p-3"></div>
    <form action="TutorController" method="post" class="bg-warning-subtle p-3 rounded-3 w-25">
        <div class="mb-3">
            <label for="email" class="form-label fw-bold">Email</label>
            <input type="text" name="email" class="form-control" id="email" placeholder="Escribe el email..." required
            onblur="comprobarCorreo()"
            >
        </div>

        <input type="hidden" value="123" name="password">
        <button type="submit" id="submit" name="accion" value="crear alumno" class="btn btn-warning disabled">Crear alumno</button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>