package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(
        name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"Email"}, name = "uk_usuario_email"),
                @UniqueConstraint(columnNames = {"DNI"}, name = "uk_usuario_dni")
        }
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

    public enum Rol {
        ADMIN, TUTOR, ALUMNO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "Email", length = 60, nullable = false)
    private String email;

    @Column(name = "Password", length = 128, nullable = false)
    private String password;

    @Column(name = "Nombre", length = 30)
    private String nombre;

    @Column(name = "Apellidos", length = 60)
    private String apellidos;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", length = 6, nullable = false)
    private Rol rol;

    @Column(name = "DNI", length = 9)
    private String dni;

    @Column(name = "UltimoAcceso")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcceso;

    @Column(name = "Avatar", length = 30, nullable = false)
    private String avatar = "avatar.png";


    public Usuario() {
        this.avatar = "avatar.png";
    }

    public Usuario(String email, String password, String nombre, String apellidos, Rol rol, String dni, Date ultimoAcceso, String avatar) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
        this.dni = dni;
        this.ultimoAcceso = ultimoAcceso;
        this.avatar = avatar != null ? avatar : "avatar.png";
    }

    // Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new es.albarregas.models.Modelo().md5(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

