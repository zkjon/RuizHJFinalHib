package es.albarregas.DAO;


import es.albarregas.beans.*;

import java.util.List;
import java.util.Objects;

public interface IUsuarioDAO {
    public Usuario getUsuarioByEmail(String email);
    public List<Tutor> getTutoresSinAlumnos();
    public List<Alumno> getAlumnosDeUnTutor(Tutor tutor);
    public Tutor getTutorDeUnAlumno(Alumno alumno);
}
