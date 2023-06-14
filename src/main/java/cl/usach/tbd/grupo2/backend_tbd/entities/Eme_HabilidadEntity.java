package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Eme_HabilidadEntity {
    private Long id_eme_habilidad;
    private Long id_emergencia;
    private Long id_habilidad;

    public Long getId_eme_habilidad() {
        return id_eme_habilidad;
    }

    public void setId_eme_habilidad(Long idEmeHabilidad) {
        this.id_eme_habilidad = idEmeHabilidad;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long idEmergencia) {
        this.id_emergencia = idEmergencia;
    }

    public Long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Long idHabilidad) {
        this.id_habilidad = idHabilidad;
    }
}
