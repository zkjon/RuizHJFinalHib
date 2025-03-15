package es.albarregas.DAO;


import es.albarregas.beans.*;

import java.util.List;
import java.util.Objects;

public interface IUsuarioDAO {
    /**
     * Obtener usuario por email
     * @param email Usuario a insertar
     * @return Usuario
     */
    public Usuario getUsuarioByEmail(String email);
    /**
     * Obtener tutores que no tienen alumnos
     * @return Lista de tutores
     */
    public List<Tutor> getTutoresSinAlumnos();
    /**
     * Obtener alumnos de un tutors
     * @param tutor Tutor
     * @return Lista de alumnos
     */
    public List<Alumno> getAlumnosDeUnTutor(Tutor tutor);
    /**
     * Obtener tutor de un alumno
     * @param alumno Alumno
     * @return Tutor
     */
    public Tutor getTutorDeUnAlumno(Alumno alumno);
}
