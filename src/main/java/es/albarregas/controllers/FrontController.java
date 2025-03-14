package es.albarregas.controllers;

import es.albarregas.DAO.ICicloDAO;
import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontController extends HttpServlet {

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
        String url = "./JSP/notify/notify.jsp";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        List<Ciclo> ciclos = null;
        List<Tutor> tutores = null;
        List<Alumno> alumnos = null;
        Map<Tutor, List<Alumno>> mapa = null;

        switch (accion) {
            case "home":
                url = ".";
                break;
            case "panel de control":
                if (usuario.getRol().equals(Usuario.Rol.ADMIN)) {
                    url = "./JSP/administrador/administrador.jsp";
                } else if (usuario.getRol().equals(Usuario.Rol.TUTOR)) {
                    url = "./JSP/tutor/tutor.jsp";
                } else if (usuario.getRol().equals(Usuario.Rol.ALUMNO)) {
                    url = "./JSP/alumno/alumno.jsp";
                }
                break;

            case "crear tutor":
                ciclos = daof.getCicloDAO().getCiclosSinAsignar();
                request.setAttribute("ciclos", ciclos);
                url = "./JSP/administrador/crearTutor.jsp";
                break;

            case "crear alumno":
                url = "./JSP/tutor/crearAlumno.jsp";
                break;

            case "actualizar datos":
                if (usuario.getRol().equals(Usuario.Rol.ALUMNO)) {
                    Alumno.Genero[] generos = Alumno.Genero.values();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaNacimiento = sdf.format(((Alumno) usuario).getFechaNacimiento());
                    request.setAttribute("generos", generos);
                    request.setAttribute("fechaNacimiento", fechaNacimiento);
                }
                url = "./JSP/usuario/actualizarDatos.jsp";
                break;

            case "eliminar profesor":
                tutores = daof.getUsuarioDAO().getTutoresSinAlumnos();
                if (!tutores.isEmpty()) {
                    request.setAttribute("tutores", tutores);
                    url = "./JSP/administrador/eliminarProfesor.jsp";
                } else {
                    request.setAttribute("mensaje", "No hay tutores sin alumnos");
                }
                break;

            case "listar profesores":
                tutores = genericoDAO.selectAll(Tutor.class);
                alumnos = genericoDAO.selectAll(Alumno.class);
                mapa = new HashMap<>();
                for (Tutor tutor : tutores) {
                    List<Alumno> alumnosDelTutor = new ArrayList<>();
                    for (Alumno alumno : alumnos) {
                        if (alumno.getCiclo().equals(tutor.getCiclo())) {
                            alumnosDelTutor.add(alumno);
                        }
                    }
                    mapa.put(tutor, alumnosDelTutor);
                }
                request.setAttribute("tutores", mapa);
                url = "./JSP/administrador/listarProfesores.jsp";
                break;

            case "eliminar alumno":
                Tutor tutorEliminar = (Tutor) request.getSession().getAttribute("usuario");
                List<Alumno> alumnosEliminar = daof.getUsuarioDAO().getAlumnosDeUnTutor(tutorEliminar);
                if (!alumnosEliminar.isEmpty()) {
                    request.setAttribute("alumnos", alumnosEliminar);
                    url = "./JSP/tutor/eliminarAlumno.jsp";
                } else {
                    request.setAttribute("mensaje", "No hay alumnos asignados a este tutor");
                }
                break;

            case "listar alumnos":
                Tutor tutorListar = (Tutor) request.getSession().getAttribute("usuario");
                List<Alumno> alumnosListar = daof.getUsuarioDAO().getAlumnosDeUnTutor(tutorListar);
                if (!alumnosListar.isEmpty()) {
                    request.setAttribute("alumnos", alumnosListar);
                    url = "./JSP/tutor/listarAlumnos.jsp";
                } else {
                    request.setAttribute("mensaje", "No hay alumnos asignados a este tutor");
                }
                break;

            case "modificar alumno":
                Tutor tutorModificar = (Tutor) request.getSession().getAttribute("usuario");
                List<Alumno> alumnosModificar = daof.getUsuarioDAO().getAlumnosDeUnTutor(tutorModificar);
                if (!alumnosModificar.isEmpty()) {
                    request.setAttribute("alumnos", alumnosModificar);
                    url = "./JSP/tutor/modificarAlumno.jsp";
                } else {
                    request.setAttribute("mensaje", "No hay alumnos asignados a este tutor");
                }
                break;

            case "ver notas":
                url = "./JSP/alumno/verNotas.jsp";
                break;

            case "ver modulos":
                request.setAttribute("tutor", daof.getUsuarioDAO().getTutorDeUnAlumno((Alumno) usuario).getNombre());
                url = "./JSP/alumno/verModulos.jsp";
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