<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="crear tutor"/>
    </c:import>

    <script src="${applicationScope.contexto}/JS/comprobarCorreo.js">
    </script>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4 mt-5 text-white">agrega un nuevo tutor al sistema</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3 align-middle">
    <div id="alert-container" class="alert-container position-fixed end-0 p-3"></div>

    <form action="AdministradorController" method="post" class="bg-warning-subtle p-3 rounded-3">
        <div class="mb-3">
            <label for="email" class="form-label fw-bold">Email</label>
            <input type="text" name="email" class="form-control" id="email" placeholder="Escribe el email..." required
            onblur="comprobarCorreo()">

        </div>
        <div class="mb-3">
            <label for="ciclo" class="form-label fw-bold">Ciclo</label>
            <select name="idCiclo" class="form-select" id="ciclo" required>
                <c:forEach var="ciclo" items="${requestScope.ciclos}" varStatus="status">
                    <c:if test="${status.index == 0}">
                        <option value="" selected disabled>Selecciona un ciclo</option>
                    </c:if>
                    <option value="${ciclo.idCiclo}">${ciclo.abreviatura}-${ciclo.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <input type="hidden" value="123" name="password">
        <button id="submit" type="submit" name="accion" value="crear tutor" class="btn btn-warning disabled">Crear tutor</button>
    </form>

</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
