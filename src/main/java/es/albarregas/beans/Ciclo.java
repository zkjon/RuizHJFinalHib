package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Ciclos")
public class Ciclo implements Serializable {
    @Id
    @Column(name = "IdCiclo", length = 7)
    private String idCiclo;

    @Column(name = "Abreviatura", length = 4, nullable = false)
    private String abreviatura;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "HorasFCT")
    private Short horasFCT;

    @Column(name = "Ley", columnDefinition = "CHAR(3)")
    private String ley;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ciclosmodulos",
            joinColumns = @JoinColumn(name = "IdCiclo"),
            inverseJoinColumns = @JoinColumn(name = "IdModulo")
    )
    private Set<Modulo> modulos;

    public Ciclo(String idCiclo, String abreviatura, String nombre) {
        this.idCiclo = idCiclo;
        this.abreviatura = abreviatura;
        this.nombre = nombre;
    }

    public Ciclo() {

    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getHorasFCT() {
        return horasFCT;
    }

    public void setHorasFCT(Short horasFCT) {
        this.horasFCT = horasFCT;
    }

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ciclo)) return false;
        Ciclo ciclo = (Ciclo) o;
        return Objects.equals(getIdCiclo(), ciclo.getIdCiclo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCiclo());
    }
}
