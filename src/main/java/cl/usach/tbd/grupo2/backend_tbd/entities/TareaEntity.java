package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TareaEntity {
    private Long idTarea;
    private String asuntoTarea;
    private Long idEmergencia;
    private Long idEstadoTarea; //ver si se mantiene como entidad aparte


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

    public Long getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(Long idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }
}
