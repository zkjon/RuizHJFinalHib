package es.albarregas.beans;

import javax.persistence.*;

@Entity
@Table(name = "familias")
public class Familia implements java.io.Serializable{

    @Id
    @Column(name = "IdFamilia", columnDefinition = "CHAR(3)")
    private String idFamilia;

    @Column(name = "Denominacion", length = 30, nullable = false)
    private String denominacion;

    public Familia(String idFamilia, String denominacion) {
        this.idFamilia = idFamilia;
        this.denominacion = denominacion;
    }

    public Familia() {
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}

