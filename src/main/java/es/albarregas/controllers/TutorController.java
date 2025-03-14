package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "TutorController", value = "/TutorController")
public class TutorController extends HttpServlet {

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
            case "crear alumno":
                Alumno alumno = new Alumno();
                Tutor tutor = (Tutor) request.getSession().getAttribute("usuario");
                try {
                    BeanUtils.populate(alumno, request.getParameterMap());
                    alumno.setRol(Alumno.Rol.ALUMNO);
                    Ciclo ciclo = (Ciclo) genericoDAO.getById(tutor.getCiclo().getIdCiclo(), Ciclo.class);
                    alumno.setCiclo(ciclo);
                    Set<Nota> notas = new HashSet<>();

                    for (Modulo modulo : ciclo.getModulos()) {
                        Nota nota = new Nota();
                        nota.setModulo(modulo);
                        nota.setNota((byte) 1);
                        nota.setAlumno(alumno);
                        notas.add(nota);
                    }

                    alumno.setNotas(notas);

                    if (daof.getUsuarioDAO().getUsuarioByEmail(alumno.getEmail()) == null) {
                        genericoDAO.insertOrUpdate(alumno);
                        url = "./JSP/notify/success.jsp";
                        request.setAttribute("mensaje", "Usuario creado correctamente");
                    } else {
                        request.setAttribute("mensaje", "El email ya está en uso");
                    }
                } catch (IllegalAccessException | InvocationTargetException e ) {
                    request.setAttribute("mensaje", "Error al crear el usuario");
                }
                break;
            case "eliminar alumno":
                Alumno alumnoEliminar = (Alumno) genericoDAO.getById(Integer.parseInt(request.getParameter("alumno")), Alumno.class);
                request.getSession().setAttribute("alumno", alumnoEliminar);
                url = "./JSP/tutor/confirmarEliminarAlumno.jsp";
                break;
            case "eliminar alumno confirmado":
                Alumno alumnoConfirmarEliminar = (Alumno) request.getSession().getAttribute("alumno");
                genericoDAO.delete(alumnoConfirmarEliminar);
                url = "./JSP/notify/success.jsp";
                request.setAttribute("mensaje", "Alumno eliminado correctamente");
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