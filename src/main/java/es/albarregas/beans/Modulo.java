package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdModulo")
    private Short idModulo;

    @Column(name = "Abreviatura", length = 5, nullable = false)
    private String abreviatura;

    @Column(name = "Curso", columnDefinition = "CHAR(1)", nullable = false)
    private String curso;

    @ManyToOne
    @JoinColumn(name = "Familia")
    private Familia familia;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "Horas", nullable = false)
    private Short horas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "IdModulo"),
            inverseJoinColumns = @JoinColumn(name = "IdCiclo")
    )
    private List<Ciclo> ciclos;

    public Modulo(Short idModulo, String abreviatura, String curso, Familia familia, String nombre, Short horas, List<Ciclo> ciclos) {
        this.idModulo = idModulo;
        this.abreviatura = abreviatura;
        this.curso = curso;
        this.familia = familia;
        this.nombre = nombre;
        this.horas = horas;
        this.ciclos = ciclos;
    }

    public Modulo() {

    }

    public Short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Short idModulo) {
        this.idModulo = idModulo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public List<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
}
