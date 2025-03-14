package es.albarregas.DAO;

import es.albarregas.beans.Ciclo;
import es.albarregas.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class CicloDAO implements ICicloDAO {

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
    public List<Ciclo> getCiclosSinAsignar() {
        List<Ciclo> ciclos = null;
        try {
            startTransaction();
            List<String> ciclosSinAsignar = sesion.createQuery("select t.ciclo.idCiclo from Tutor t").list();
            if (ciclosSinAsignar.size() > 0) {
                ciclos = sesion.createQuery("from Ciclo c where c.idCiclo not in (:ciclosSinAsignar)")
                        .setParameterList("ciclosSinAsignar", ciclosSinAsignar)
                        .list();
            } else {
                ciclos = sesion.createQuery("from Ciclo").list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTransaction();
        }
        return ciclos;
    }
}
