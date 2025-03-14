package es.albarregas.DAOFactory;

import es.albarregas.DAO.ICicloDAO;
import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.IUsuarioDAO;

public abstract class DAOFactory {

    public abstract IGenericoDAO getGenericoDAO();
    public abstract ICicloDAO getCicloDAO();
    public abstract IUsuarioDAO getUsuarioDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = new MySQLDAOFactory();

        return daof;
    }

}