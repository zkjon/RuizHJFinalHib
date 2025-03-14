package es.albarregas.DAOFactory;

import es.albarregas.DAO.*;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

    @Override
    public ICicloDAO getCicloDAO() {
        return new CicloDAO();
    }
    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
}