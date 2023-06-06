package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;
import cl.usach.tbd.grupo2.backend_tbd.entities.InstitucionEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.InstitucionRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository

public class InstitucionRepositoryImpl implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<InstitucionEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id, nombre, direccion, telefono FROM institucion";
            return connection.createQuery(query).executeAndFetch(InstitucionEntity.class);
        }
    }
    @Override
    public InstitucionEntity findById(Long id) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id, nombre, direccion, telefono FROM institucion WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(InstitucionEntity.class);
        }
    }
    @Override
    public void create(InstitucionEntity institucion) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "INSERT INTO institucion (nombre, direccion, telefono) VALUES (:nombre, :direccion, :telefono)";
            connection.createQuery(query)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .addParameter("telefono", institucion.getTelefono())
                    .executeUpdate();
            connection.commit();
        }
    }
    @Override
    public void update(InstitucionEntity institucion) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "UPDATE institucion SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .addParameter("telefono", institucion.getTelefono())
                    .addParameter("id", institucion.getIdInstitucion())
                    .executeUpdate();
            connection.commit();
        }
    }
    @Override
    public void delete(Long id) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "DELETE FROM institucion WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            connection.commit();
        }
    }


}
