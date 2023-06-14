package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TareaEntity {
    private Long id_tarea;
    private String asunto_tarea;
    private Long id_emergencia;
    private Boolean estado_tarea; //ver si se mantiene como entidad aparte

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long idTarea) {
        this.id_tarea = idTarea;
    }

    public String getAsunto_tarea() {
        return asunto_tarea;
    }

    public void setAsunto_tarea(String asuntoTarea) {
        this.asunto_tarea = asuntoTarea;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long idEmergencia) {
        this.id_emergencia = idEmergencia;
    }

    public Boolean getEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(Boolean estadoTarea) {
        this.estado_tarea = estadoTarea;
    }
}
