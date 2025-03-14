package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.IUsuarioDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Nota;
import es.albarregas.beans.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxController", value = "/AjaxController")
public class AjaxController extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equals("modificarNota")) {
            String alumnoId = request.getParameter("alumnoId");
            String moduloId = request.getParameter("moduloId");
            String nuevaNota = request.getParameter("nuevaNota");

            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO genericoDAO = daof.getGenericoDAO();
            Alumno alumno = (Alumno) genericoDAO.getById(Integer.parseInt(alumnoId), Alumno.class);

            boolean updateSuccess = false;
            for (Nota nota : alumno.getNotas()) {
                if (nota.getModulo().getIdModulo() == Integer.parseInt(moduloId)) {
                    nota.setNota(Byte.parseByte(nuevaNota));
                    genericoDAO.insertOrUpdate(alumno);
                    updateSuccess = true;
                    break;
                }
            }

            response.setContentType("application/json");
            response.getWriter().write("{\"success\": " + updateSuccess + "}");
        } else if (accion.equals("comprobarCorreo")) {
            String email = request.getParameter("email");

            DAOFactory daof = DAOFactory.getDAOFactory();
            IUsuarioDAO usuarioDAO = daof.getUsuarioDAO();
            Usuario usuario = usuarioDAO.getUsuarioByEmail(email);

            boolean emailSuccess = (usuario == null);

            response.setContentType("application/json");
            response.getWriter().write("{\"success\": " + emailSuccess + "}");
        } else {
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": false}");
        }
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