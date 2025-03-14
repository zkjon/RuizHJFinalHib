package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author zkjon
 */
@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "FK_alumnos_usuarios"))
public class Alumno extends Usuario implements Serializable {

    public enum Genero {
        Mujer, Hombre, Otro
    }

    @Column(name = "Genero", columnDefinition = "VARCHAR(6) NOT NULL DEFAULT 'Mujer'")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "FechaNacimiento", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCiclo", nullable = false, foreignKey = @ForeignKey(name = "FK_alumnos_ciclos"))
    private Ciclo ciclo;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "FK_alumnos_notas"))
    private Set<Nota> notas;

    @Transient
    private double notaPonderada;

    // Constructors
    public Alumno() {
        this.genero = Genero.Mujer;
    }


    // Getters & Setters
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Set<Nota> getNotas() {
        return notas;
    }

    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }

    public double getNotaPonderada() {
        double sumaNotasPonderadas = 0;
        int sumaHoras = 0;

        for (Nota nota : notas) {
            short horas = nota.getModulo().getHoras();
            byte notaModulo = nota.getNota();

            sumaNotasPonderadas += notaModulo * horas;
            sumaHoras += horas;
        }

        return sumaHoras == 0 ? 0 : sumaNotasPonderadas / sumaHoras;
    }


    public void setNotaPonderada(double notaPonderada) {
        this.notaPonderada = notaPonderada;
  }
}