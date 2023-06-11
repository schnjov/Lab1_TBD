package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.implementations.UserDetailsRepositoryImpl;

import java.util.List;

public interface UsuarioRepository {
    public List<UsuarioEntity> findAll();

    public UsuarioEntity findById(Long id);

    public UsuarioEntity getByEmail(String email);

    public void create(UsuarioEntity usuario);

    public void update(UsuarioEntity usuario);

    public void delete(Long id);
}
