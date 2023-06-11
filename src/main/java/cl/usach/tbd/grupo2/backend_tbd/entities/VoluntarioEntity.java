package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.postgis.jdbc.PGgeometry;

@AllArgsConstructor
@NoArgsConstructor
public class VoluntarioEntity {
    private Long id_voluntario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    private Long id_usuario;

    private PGgeometry ubicacion;


    // Getters y Setters
    public Long getId() {
        return id_voluntario;
    }

    public void setId(Long id) {
        this.id_voluntario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public PGgeometry getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(PGgeometry ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
