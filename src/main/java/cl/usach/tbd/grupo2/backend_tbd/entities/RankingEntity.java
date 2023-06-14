package cl.usach.tbd.grupo2.backend_tbd.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RankingEntity {
    private Long id_ranking;
    private Long id_tarea;
    private Long id_voluntario;
    private Long puntaje;

    public Long getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(Long idRanking) {
        this.id_ranking = idRanking;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long idTarea) {
        this.id_tarea = idTarea;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long idVoluntario) {
        this.id_voluntario = idVoluntario;
    }

    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }
}
