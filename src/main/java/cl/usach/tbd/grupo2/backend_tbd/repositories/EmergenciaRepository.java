package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.EmergenciaEntity;

import java.util.List;

public interface EmergenciaRepository {
    public List<EmergenciaEntity> findAll();
    public EmergenciaEntity create(EmergenciaEntity emergencia);
    public EmergenciaEntity findById(Long id);
    public EmergenciaEntity update(EmergenciaEntity emergencia);
    public void delete(Long id);
}
