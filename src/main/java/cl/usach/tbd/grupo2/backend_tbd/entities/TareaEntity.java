package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TareaEntity {
    private Long idTarea;
    private String asuntoTarea;
    private Long idEmergencia;
    private Boolean estadoTarea; //ver si se mantiene como entidad aparte


    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getAsuntoTarea() {
        return asuntoTarea;
    }

    public void setAsuntoTarea(String asuntoTarea) {
        this.asuntoTarea = asuntoTarea;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public Boolean getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }
}
