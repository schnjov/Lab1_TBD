package cl.usach.tbd.grupo2.backend_tbd.repositories.implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.UsuarioRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Sql2o sql2o;

    public UsuarioRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<UsuarioEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id, email, rol FROM usuario";
            return connection.createQuery(query).executeAndFetch(UsuarioEntity.class);
        }
    }

    @Override
    public UsuarioEntity findById(Long id) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM usuario WHERE id = :id";
            return connection.createQuery(query).addParameter("id", id).executeAndFetchFirst(UsuarioEntity.class);
        }
    }

    @Override
    public UsuarioEntity getByEmail(String email) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM usuario WHERE email = :email";
            return connection.createQuery(query).addParameter("email", email).executeAndFetchFirst(UsuarioEntity.class);
        }
    }


    @Override
    public void create(UsuarioEntity usuario) {
        try (Connection connection = sql2o.open()) {
            String query = "INSERT INTO usuario (email, password, rol) VALUES (:email, :password, :rol)";
            connection.createQuery(query, true)
                    .addParameter("email", usuario.getEmail())
                    .addParameter("password", usuario.getPassword())
                    .addParameter("rol", usuario.getRol())
                    .executeUpdate();
        }
    }

    @Override
    public void update(UsuarioEntity usuario) {
        try (Connection connection = sql2o.open()) {
            String query = "UPDATE usuario SET email = :email, password = :password, rol = :rol WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("email", usuario.getEmail())
                    .addParameter("password", usuario.getPassword())
                    .addParameter("rol", usuario.getRol())
                    .addParameter("id", usuario.getId())
                    .executeUpdate();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = sql2o.open()) {
            String query = "DELETE FROM usuario WHERE id = :id";
            connection.createQuery(query).addParameter("id", id).executeUpdate();
        }
    }
}
