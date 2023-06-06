package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.InstitucionEntity;
import java.util.List;

public interface InstitucionRepository {
    public List<InstitucionEntity> findAll();
    public void create(InstitucionEntity institucion);
    public InstitucionEntity findById(Long id);
    public void update(InstitucionEntity institucion);
    public void delete(Long id);
    
}
