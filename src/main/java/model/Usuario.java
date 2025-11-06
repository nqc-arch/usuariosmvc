package model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "pkusuario")
    private Integer pkusuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    public Usuario() {
    }

    public Usuario(Integer pkusuario, String nombre, String correo) {
        this.pkusuario = pkusuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getPkusuario() {
        return this.pkusuario;
    }

    public void setPkusuario(Integer pkusuario) {
        this.pkusuario = pkusuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
