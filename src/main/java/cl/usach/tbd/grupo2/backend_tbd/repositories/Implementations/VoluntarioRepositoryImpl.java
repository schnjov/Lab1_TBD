package cl.usach.tbd.grupo2.backend_tbd.repositories.implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.VoluntarioRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImpl implements VoluntarioRepository {
    private final Sql2o sql2o;

    public VoluntarioRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<VoluntarioEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id, nombre, apellido, email, telefono, direccion FROM voluntario";
            return connection.createQuery(query).executeAndFetch(VoluntarioEntity.class);
        }
    }

    @Override
    public VoluntarioEntity findById(Long id) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id, nombre, apellido, email, telefono, direccion FROM voluntario WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        }
    }

    @Override
    public void create(VoluntarioEntity voluntario) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "INSERT INTO voluntario (nombre, apellido, email, telefono, direccion) VALUES (:nombre, :apellido, :email, :telefono, :direccion)";
            connection.createQuery(query)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("direccion", voluntario.getDireccion())
                    .executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void update(VoluntarioEntity voluntario) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "UPDATE voluntario SET nombre = :nombre, apellido = :apellido, email = :email, telefono = :telefono, direccion = :direccion WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("direccion", voluntario.getDireccion())
                    .addParameter("id", voluntario.getId())
                    .executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "DELETE FROM voluntario WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            connection.commit();
        }
    }
}
