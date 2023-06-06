package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.HabilidadEntity;

import java.util.List;

public interface HabilidadRepository {
    public List<HabilidadEntity> findAll();
    public void create(HabilidadEntity habilidad);
    public HabilidadEntity findById(Long id);
    public void update(HabilidadEntity habilidad);
    public void delete(Long id);


}
