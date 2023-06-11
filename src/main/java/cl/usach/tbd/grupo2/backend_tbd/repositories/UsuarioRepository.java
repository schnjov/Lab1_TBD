package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository {
    public List<UsuarioEntity> findAll();

    public UsuarioEntity findById(Long id);

    public UsuarioEntity getByEmail(String email);

    public void create(UsuarioEntity usuario);

    public void update(UsuarioEntity usuario);

    public void delete(Long id);
}
