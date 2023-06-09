package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.Vol_HabilidadEntity;

import java.util.List;

public interface Vol_HabilidadRepository {
    public List<Vol_HabilidadEntity> findAll();
    public void create(Vol_HabilidadEntity vol_habilidad);
    public Vol_HabilidadEntity findByIdVolHabilidad(Long id);
    public void update(Vol_HabilidadEntity vol_habilidad);
    public void delete(Long id);
}
