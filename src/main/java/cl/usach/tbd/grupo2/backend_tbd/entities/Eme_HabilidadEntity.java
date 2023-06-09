package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Eme_HabilidadEntity {
    private Long idEmeHabilidad;
    private Long idEmergencia;
    private Long idHabilidad;

    public Long getIdEmeHabilidad() {
        return idEmeHabilidad;
    }

    public void setIdEmeHabilidad(Long idEmeHabilidad) {
        this.idEmeHabilidad = idEmeHabilidad;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
