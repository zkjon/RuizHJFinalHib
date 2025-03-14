package es.albarregas.beans;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "fk_administrador_usuario"))
public class Administrador extends Usuario implements Serializable {

    @Column(name = "ModoDios", columnDefinition = "CHAR(1)")
    @Type(type = "true_false")
    private Boolean modoDios;

    // Constructor
    public Administrador(String email, String password, String nombre, String apellidos, Rol rol, String dni, Date ultimoAcceso, String avatar, boolean modoDios) {
        super(email, password, nombre, apellidos, rol, dni, ultimoAcceso, avatar);
        this.modoDios = modoDios;
    }

    public Administrador() {
    }

    // Getter y Setter
    public boolean isModoDios() {
        return modoDios;
    }

    public void setModoDios(boolean modoDios) {
        this.modoDios = modoDios;
    }
}
