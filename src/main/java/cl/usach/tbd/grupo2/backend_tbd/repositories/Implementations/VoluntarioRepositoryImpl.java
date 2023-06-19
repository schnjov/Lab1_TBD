package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.VoluntarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

            String query = "SELECT * FROM voluntario";
            return connection.createQuery(query).executeAndFetch(VoluntarioEntity.class);
        }
    }

    @Override
    public VoluntarioEntity findById(Long id) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM voluntario WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        }
    }

    @Override
    public List<VoluntarioEntity> findByEmergenciaAndRadio(Long idEmergencia, Double radio)
    {
        String query =
                "SELECT DISTINCT v.* " +
                        "FROM voluntario v " +
                        "JOIN vol_habilidad vh ON v.id = vh.id_voluntario " +
                        "JOIN eme_habilidad eh ON vh.id_habilidad = eh.id_habilidad " +
                        "JOIN emergencia e ON eh.id_emergencia = e.id " +
                        "WHERE e.id = :idEmergencia AND ST_DWithin(v.ubicacion::geography, e.ubicacion::geography, :radio)";

        try (Connection con = sql2o.open()) {
            return con.createQuery(query)
                    .addParameter("idEmergencia", idEmergencia)
                    .addParameter("radio", radio)
                    .executeAndFetch(VoluntarioEntity.class);
        }
    }

    @Override
    public void create(VoluntarioEntity voluntario) {
        try (Connection connection = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            connection.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            String query = "INSERT INTO voluntario (nombre, apellido, telefono, direccion, ubicacion) VALUES (:nombre, :apellido, :telefono, :direccion, :ubicacion)";
            connection.createQuery(query)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("direccion", voluntario.getDireccion())
                    .addParameter("ubicacion", voluntario.getUbicacion())
                    .executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void update(VoluntarioEntity voluntario) {
        try (Connection connection = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            connection.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            String query = "UPDATE voluntario SET nombre = :nombre, apellido = :apellido, telefono = :telefono, direccion = :direccion, ubicacion = :ubicacion WHERE id_voluntario = :id";
            connection.createQuery(query)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("direccion", voluntario.getDireccion())
                    .addParameter("id", voluntario.getId())
                    .addParameter("ubicacion", voluntario.getUbicacion())
                    .executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            connection.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            String query = "DELETE FROM voluntario WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            connection.commit();
        }
    }
}
