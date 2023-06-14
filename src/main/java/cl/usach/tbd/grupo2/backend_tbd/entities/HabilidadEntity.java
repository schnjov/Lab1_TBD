package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class HabilidadEntity {
    private Long id_habilidad;
    private String habilidad;

    public Long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Long idHabilidad) {
        this.id_habilidad = idHabilidad;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
