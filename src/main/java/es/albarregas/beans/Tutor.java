package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tutores")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "fk_tutores_usuario"))
public class Tutor extends Usuario implements Serializable {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCiclo", foreignKey = @ForeignKey(name = "fk_tutores_ciclos"))
    private Ciclo ciclo;
    public Tutor() {
    }

    // Getter y Setter
    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tutor{ciclo=" + ciclo + '}';
    }
}

