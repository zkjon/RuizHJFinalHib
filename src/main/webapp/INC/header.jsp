<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header d-flex justify-content-between align-items-center shadow bg-warning-subtle position-sticky top-0" style="min-height: 15vh">

    <form action="FrontController" method="post">
        <button type="submit" name="accion" value="home" class="border-0 bg-warning-subtle">
            <img src="${pageContext.servletContext.contextPath}/IMG/logo.png" alt="logo" class="img-fluid" style="max-height: 10vh;">
        </button>
    </form>


    <c:if test="${empty sessionScope.usuario}">
        <button type="button" class="btn btn-warning me-4 fs-4" data-bs-toggle="modal" data-bs-target="#modalLogin">Iniciar sesi&oacute;n</button>
    </c:if>

    <c:if test="${!empty sessionScope.usuario}">
        <div class="d-flex align-items-center gap-3">
            <p class="fs-4 text-center m-0">Bienvenido ${sessionScope.usuario.rol}, ${sessionScope.usuario.nombre}</p>

            <div class="fs-4 d-flex gap-2 p-2">
                <form action="FrontController" method="post">
                    <button type="submit" name="accion" value="panel de control" class="btn btn-warning me-4 fs-4">Panel de control</button>
                </form>

                <form action="Acceso" method="post">
                    <button type="submit" name="accion" value="logout" class="btn btn-danger me-4 fs-4">Cerrar Sesi&oacute;n</button>
                </form>
            </div>
        </div>
    </c:if>
</header>


<c:if test="${empty sessionScope.usuario}">
    <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="modalLoginLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form class="modal-content" method="post" action="Acceso">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLoginLabel">Iniciar sesi&oacute;n</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body
                    ">
                    <input type="text" name="email" class="form-control mb-2" placeholder="Correo electr&oacute;nico" required>
                    <input type="password" name="password" class="form-control mb-2" placeholder="Contrase&ntilde;a" required>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" name="accion" value="login" class="btn btn-warning">Iniciar sesi&oacute;n</button>
                </div>
            </form>
        </div>
    </div>
</c:if>
<img src="${pageContext.servletContext.contextPath}/IMG/fondo.jpg" alt="fondo" class="fondo position-absolute top-0 start-0 w-100 h-100 object-fit-cover z-n1 opacity-50">
