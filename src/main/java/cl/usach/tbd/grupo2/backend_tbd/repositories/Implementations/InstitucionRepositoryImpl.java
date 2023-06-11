package cl.usach.tbd.grupo2.backend_tbd.repositories.implementations;
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
            String query = "SELECT * FROM institucion";
            return connection.createQuery(query).executeAndFetch(InstitucionEntity.class);
        }
    }

    @Override
    public InstitucionEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM institucion WHERE id_institucion = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public void create(InstitucionEntity institucion) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "INSERT INTO institucion (id_institucion, nombre, direccion, telefono, id_usuario) VALUES (:idInstitucion, :nombre, :direccion, :telefono, :id_usuario)";
            connection.createQuery(query)
                    .addParameter("idInstitucion", institucion.getIdInstitucion())
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .addParameter("telefono", institucion.getTelefono())
                    .addParameter("id_usuario",institucion.getId_usuario())
                    .executeUpdate();
            connection.commit();
        }
    }
    @Override
    public void update(InstitucionEntity institucion) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "UPDATE institucion SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE id_institucion = :idInstitucion";
            connection.createQuery(query)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .addParameter("telefono", institucion.getTelefono())
                    .addParameter("idInstitucion", institucion.getIdInstitucion())
                    .executeUpdate();
            connection.commit();
        }
    }
    @Override
    public void delete(Long id) {
        try (Connection connection = sql2o.beginTransaction()) {
            String query = "DELETE FROM institucion WHERE id_institucion = :idInstitucion";
            connection.createQuery(query)
                    .addParameter("idInstitucion", id)
                    .executeUpdate();
            connection.commit();
        }
    }
}
