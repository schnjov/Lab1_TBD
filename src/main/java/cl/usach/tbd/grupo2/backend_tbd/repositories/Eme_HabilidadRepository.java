package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.Eme_HabilidadEntity;

import java.util.List;

public interface Eme_HabilidadRepository {
    public List<Eme_HabilidadEntity> findAll();
    public void create(Eme_HabilidadEntity eme_habilidad);
    public Eme_HabilidadEntity findById(Long id);
    public void update(Eme_HabilidadEntity eme_habilidad);
    public void delete(Long id);
}
