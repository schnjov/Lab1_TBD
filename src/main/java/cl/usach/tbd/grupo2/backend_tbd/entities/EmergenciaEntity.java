package cl.usach.tbd.grupo2.backend_tbd.entities;

import cl.usach.tbd.grupo2.backend_tbd.serializers.PGgeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.postgis.jdbc.PGgeometry;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class EmergenciaEntity {
    private Long id_emergencia;
    private String asunto;
    private String descripcion;
    private String direccion;
    private Date fecha;
    public Boolean activa;
    private Integer id_institucion;
    private Integer region;

    @JsonSerialize(using = PGgeometrySerializer.class)
    private PGgeometry ubicacion;

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Integer getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Integer getRegion() {
        return this.region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public PGgeometry getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(PGgeometry ubicacion) {
        this.ubicacion = ubicacion;
    }


}
