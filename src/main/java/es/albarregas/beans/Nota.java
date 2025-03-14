package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notas")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNota")
    private Integer idNota;

    @Column(name = "Nota", nullable = false)
    private Byte nota;

    @ManyToOne
    @JoinColumn(name = "IdAlumno", foreignKey = @ForeignKey(name = "fk_notas_alumnos"))
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "IdModulo", foreignKey = @ForeignKey(name = "fk_notas_modulos"))
    private Modulo modulo;

    public Nota(int idNota, byte nota, Alumno alumno, Modulo modulo) {
        this.idNota = idNota;
        this.nota = nota;
        this.alumno = alumno;
        this.modulo = modulo;
    }

    public Nota() {

    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Byte getNota() {
        return nota;
    }

    public void setNota(Byte nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
