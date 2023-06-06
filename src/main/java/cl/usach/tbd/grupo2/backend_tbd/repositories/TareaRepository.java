package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.TareaEntity;

import java.util.List;

public interface TareaRepository {

    public void create(TareaEntity tarea);

    public List<TareaEntity> findAll();

    public TareaEntity findById(Long id);

    public List<TareaEntity> findByIdEmergencia(Long id);

    public void update(TareaEntity tarea);

    public void delete(Long id);
}
