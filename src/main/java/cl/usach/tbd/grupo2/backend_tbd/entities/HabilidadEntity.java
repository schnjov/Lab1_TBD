package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class HabilidadEntity {
    private Long idHabilidad;
    private String Habilidad;

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getHabilidad() {
        return Habilidad;
    }

    public void setHabilidad(String habilidad) {
        Habilidad = habilidad;
    }
}
