package es.albarregas.DAO;

import es.albarregas.beans.Ciclo;

import java.util.List;

public interface ICicloDAO {
    public List<Ciclo> getCiclosSinAsignar();
}
