package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AdministradorController", value = "/AdministradorController")
public class AdministradorController extends HttpServlet {

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
        String accion = request.getParameter("accion");
        String url ="./JSP/notify/notify.jsp";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();

        switch (accion){
            case "crear tutor":
                Tutor tutor = new Tutor();
                try {
                    BeanUtils.populate(tutor, request.getParameterMap());

                    Ciclo ciclo = (Ciclo) genericoDAO.getById(request.getParameter("idCiclo"), Ciclo.class);
                    tutor.setCiclo(ciclo);
                    tutor.setRol(Usuario.Rol.TUTOR);

                    genericoDAO.insertOrUpdate(tutor);
                    url = "./JSP/notify/success.jsp";
                    request.setAttribute("mensaje", "Tutor creado correctamente");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    request.setAttribute("mensaje", "Error al crear el tutor");
                }
                break;

            case "eliminar tutor":
                Tutor tutorEliminar = (Tutor) genericoDAO.getById(Integer.parseInt(request.getParameter("tutor")), Tutor.class);
                request.getSession().setAttribute("tutor", tutorEliminar);
                url = "./JSP/administrador/confirmarEliminarProfesor.jsp";
                break;

            case "eliminar tutor confirmado":
                Tutor tutorEliminarConfirmado = (Tutor) request.getSession().getAttribute("tutor");
                genericoDAO.delete(tutorEliminarConfirmado);
                url = "./JSP/notify/success.jsp";
                request.setAttribute("mensaje", "Tutor eliminado correctamente");
                break;

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