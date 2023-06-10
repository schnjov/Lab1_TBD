package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.Vol_HabilidadEntity;

import java.util.List;

public interface Vol_HabilidadRepository {
    public List<Vol_HabilidadEntity> findAll();
    public void create(Vol_HabilidadEntity vol_habilidad);
    public Vol_HabilidadEntity findById(Long id);
    public List<Vol_HabilidadEntity> findByIdVoluntario(Long idVoluntario);
    public List<Vol_HabilidadEntity> findByIdHabilidad(Long idHabilidad);
    public void update(Vol_HabilidadEntity vol_habilidad);
    public void delete(Long id);
}
