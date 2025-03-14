package es.albarregas.DAO;

import es.albarregas.beans.*;
import es.albarregas.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    private Session sesion;

    protected void startTransaction() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.getTransaction().begin();
    }

    protected void endTransaction() {
        if (sesion.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            sesion.getTransaction().commit();
        }
        sesion.close();
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = null;
        try {
            startTransaction();
            usuario = (Usuario) sesion.createQuery("from Usuario u where u.email= :email")
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTransaction();
        }
        return usuario;
    }

    @Override
    public List<Tutor> getTutoresSinAlumnos() {
        List<Tutor> tutores = null;
        try {
            startTransaction();
            tutores = sesion.createQuery(
                            "FROM Tutor t WHERE t.ciclo.idCiclo NOT IN (SELECT DISTINCT a.ciclo.idCiclo FROM Alumno a)")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTransaction();
        }
        return tutores;
    }

    @Override
    public List<Alumno> getAlumnosDeUnTutor(Tutor tutor){
        List<Alumno> alumnos = null;
        try {
            startTransaction();
            alumnos = sesion.createQuery("FROM Alumno a WHERE a.ciclo.idCiclo = :idCiclo")
                    .setParameter("idCiclo", tutor.getCiclo().getIdCiclo())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTransaction();
        }
        return alumnos;
    }

    @Override
    public Tutor getTutorDeUnAlumno(Alumno alumno) {
        Tutor tutor = null;
        try {
            startTransaction();
            tutor = (Tutor) sesion.createQuery("SELECT t FROM Tutor t JOIN t.ciclo c WHERE c.idCiclo = :ciclo")
                    .setParameter("ciclo", alumno.getCiclo().getIdCiclo())
                    .uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            endTransaction();
        }
        return tutor;
    }


}
