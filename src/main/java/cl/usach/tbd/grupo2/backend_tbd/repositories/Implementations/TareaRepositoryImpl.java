package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.TareaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.TareaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TareaRepositoryImpl implements TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public void create(TareaEntity tarea) {
        String sqlQuery = "INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, estado_tarea) VALUES (:idTarea, :asuntoTarea, :idEmergencia, :estadoTarea)";
        try (Connection con = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            con.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            con.createQuery(sqlQuery)
                    .addParameter("idTarea", tarea.getId_tarea())
                    .addParameter("asuntoTarea", tarea.getAsunto_tarea())
                    .addParameter("idEmergencia", tarea.getId_emergencia())
                    .addParameter("estadoTarea", tarea.getEstado_tarea())
                    .executeUpdate();
            con.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public List<TareaEntity> findAll() {
        List<TareaEntity> tareas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM tarea ORDER BY id_tarea ASC";
        try (Connection con = sql2o.open()){
            tareas = con.createQuery(sqlQuery).executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);
        }
        return tareas;
    }

    @Override
    public TareaEntity findById(Long id) {
        TareaEntity tarea = null;
        String sqlQuery = "SELECT * FROM tarea WHERE id_tarea = :idTarea";
        try (Connection con = sql2o.open()){
            tarea = (TareaEntity)con.createQuery(sqlQuery).addParameter("idTarea", id).executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);
        }
        return tarea;
    }

    @Override
    public List<TareaEntity> findByIdEmergencia(Long id) {
        List<TareaEntity> tareas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM tarea WHERE id_emergencia = :idEmergencia";
        try (Connection con = sql2o.open()){
            tareas = con.createQuery(sqlQuery).addParameter("idEmergencia", id).executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);
        }
        return tareas;
    }

    @Override
    public List<TareaEntity> findByRegion(int region) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT t.* FROM tarea t INNER JOIN emergencia e ON t.id_emergencia = e.id_emergencia WHERE e.region = :region";
            return connection.createQuery(query)
                    .addParameter("region", region)
                    .executeAndFetch(TareaEntity.class);
        }
    }

    @Override
    public void update(TareaEntity tarea) {
        String sqlQuery = "UPDATE tarea SET asunto_tarea = :asuntoTarea, id_emergencia = :idEmergencia, estado_tarea = :estadoTarea WHERE id_tarea = :idTarea";
        try (Connection con = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            con.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            con.createQuery(sqlQuery)
                    .addParameter("asuntoTarea", tarea.getAsunto_tarea())
                    .addParameter("idEmergencia", tarea.getId_emergencia())
                    .addParameter("estadoTarea", tarea.getEstado_tarea())
                    .addParameter("idTarea", tarea.getId_tarea())
                    .executeUpdate();
            con.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM tarea WHERE id_tarea = :id";
        try (Connection con = sql2o.beginTransaction()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            String sqlSet = "SELECT set_tbd_usuario(:username)";
            con.createQuery(sqlSet)
                    .addParameter("username", username)
                    .executeScalar();

            con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeUpdate();
            con.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
