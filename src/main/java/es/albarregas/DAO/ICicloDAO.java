package es.albarregas.DAO;

import es.albarregas.beans.Ciclo;

import java.util.List;

public interface ICicloDAO {
    /**
     * Obtener ciclos que no están asignados a ningún profesor
     * @return Lista de ciclos
     */
    public List<Ciclo> getCiclosSinAsignar();
}
