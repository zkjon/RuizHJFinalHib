package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.models.EnumConverter;
import es.albarregas.models.Modelo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "CompletarRegistro", value = "/CompletarRegistro")
public class CompletarRegistro extends HttpServlet {

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

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        if (usuario != null) {
            if (usuario.getRol() == Usuario.Rol.TUTOR) {
                usuario = (Tutor) request.getSession().getAttribute("usuario");
            } else {
                usuario = (Alumno) request.getSession().getAttribute("usuario");
            }

            try {
                DateConverter dateConverter = new DateConverter();
                dateConverter.setPattern("yyyy-MM-dd");
                ConvertUtils.register(new EnumConverter(), Alumno.Genero.class);
                ConvertUtils.register(dateConverter, java.util.Date.class);
                BeanUtils.populate(usuario, request.getParameterMap());

                if (request.getParameter("password2") != null && !request.getParameter("password2").trim().isEmpty()) {
                    usuario.setPassword(request.getParameter("password2"));
                }

                usuario.setUltimoAcceso(Modelo.getFechaActual());

                genericoDAO.insertOrUpdate(usuario);
                request.getSession().setAttribute("usuario", usuario);
                request.setAttribute("mensaje", "Completado con éxito");
                url = "/JSP/notify/success.jsp";

            } catch (IllegalAccessException | InvocationTargetException e) {
                request.setAttribute("mensaje", "Error al completar el registro");
            }
        } else {
            request.setAttribute("mensaje", "Error al completar el registro");
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