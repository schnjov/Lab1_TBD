package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;

import java.util.List;

public interface VoluntarioRepository {
    public List<VoluntarioEntity> findAll();

    public VoluntarioEntity findById(Long id);

    public void create(VoluntarioEntity voluntario);

    public void update(VoluntarioEntity voluntario);

    public void delete(Long id);
}
