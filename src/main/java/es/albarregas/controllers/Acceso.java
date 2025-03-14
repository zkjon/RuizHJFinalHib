package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.IUsuarioDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Usuario;
import es.albarregas.models.Modelo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Acceso", value = "/Acceso")
public class Acceso extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/JSP/notify/notify.jsp";

        String accion = request.getParameter("accion");
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        IUsuarioDAO usuarioDAO = daof.getUsuarioDAO();
        Usuario usuario = null;
        Modelo modelo = new Modelo();

        if (accion.equals("login")){
            String email = request.getParameter("email");
            usuario = usuarioDAO.getUsuarioByEmail(email);

            if (usuario != null) {
                String password = modelo.md5(request.getParameter("password"));
                if (usuario.getPassword().equalsIgnoreCase(password)) {
                    switch (usuario.getRol()) {
                        case ADMIN:
                            url = "./JSP/administrador/administrador.jsp";
                            usuario.setUltimoAcceso(Modelo.getFechaActual());
                            break;
                        case TUTOR:
                            if (usuario.getUltimoAcceso() == null) {
                                url = "./JSP/usuario/completarRegistro.jsp";
                            } else {
                                url = "./JSP/tutor/tutor.jsp";
                                usuario.setUltimoAcceso(Modelo.getFechaActual());
                            }
                            break;
                        case ALUMNO:
                            if (usuario.getUltimoAcceso() == null) {
                                Alumno.Genero[] generos = Alumno.Genero.values();
                                request.setAttribute("generos", generos);
                                url = "./JSP/usuario/completarRegistro.jsp";
                            } else {
                                url = "./JSP/alumno/alumno.jsp";
                                usuario.setUltimoAcceso(Modelo.getFechaActual());
                            }
                            break;
                        default:
                            url = "/JSP/index.jsp";
                            break;
                    }
                    request.getSession().setAttribute("usuario", usuario);
                } else {
                    request.setAttribute("mensaje", "contraseña incorrecta");
                }
            } else {
                request.setAttribute("mensaje", "el usuario no existe");
            }
        } else {
            request.getSession().invalidate();
            url = ".";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}