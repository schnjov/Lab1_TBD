package cl.usach.tbd.grupo2.backend_tbd.entities;

public class Vol_HabilidadEntity {
    private Long id_vol_habilidad;
    private Long id_voluntario;
    private Long id_habilidad;

    public Long getIdVolHabilidad() {
        return id_vol_habilidad;
    }

    public void setIdVolHabilidad(Long idVolHabilidad) {
        this.id_vol_habilidad = idVolHabilidad;
    }

    public Long getIdVoluntario() {
        return id_voluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.id_voluntario = idVoluntario;
    }

    public Long getIdHabilidad() {
        return id_habilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.id_habilidad = idHabilidad;
    }
}
