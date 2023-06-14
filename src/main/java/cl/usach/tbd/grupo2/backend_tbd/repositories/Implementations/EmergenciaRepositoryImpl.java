package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.EmergenciaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.EmergenciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmergenciaRepositoryImpl implements EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;
    private final Logger logger = LoggerFactory.getLogger(EmergenciaRepositoryImpl.class);

    @Override
    public List<EmergenciaEntity> findAll() {
        List<EmergenciaEntity> emergencias = new ArrayList<>();
        String sqlQuery = "SELECT * FROM emergencia ORDER BY id_emergencia ASC";
        try (Connection con = sql2o.open()) {
            emergencias = con.createQuery(sqlQuery).executeAndFetch(EmergenciaEntity.class);
            logger.info("Cantidad de emergencias: " + emergencias.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
            // Conexion a sql ha fallado

        }
        return emergencias;
    }

    @Override
    public EmergenciaEntity create(EmergenciaEntity emergencia) {
        String sqlQuery = "INSERT INTO emergencia (id_emergencia, asunto, fecha, descripcion, direccion, activa, id_institucion, region, ubicacion) VALUES (:id_emergencia, :asunto, :fecha, :descripcion, :direccion, :activa, :id_institucion, :region, :ubicacion)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("asunto", emergencia.getAsunto())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("direccion", emergencia.getDireccion())
                    .addParameter("activa", emergencia.getActiva())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .addParameter("region", emergencia.getRegion())
                    .addParameter("ubicacion", emergencia.getUbicacion())
                    .executeUpdate();
            con.commit();
        }
        return null;
    }

    @Override
    public EmergenciaEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM emergencia WHERE id_emergencia = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public EmergenciaEntity findByTarea(Long idTarea) {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT e.* FROM emergencia e INNER JOIN tarea t ON t.id_emergencia = e.id_emergencia WHERE t.id_tarea = :idTarea";
            return connection.createQuery(query)
                    .addParameter("idTarea", idTarea)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        }
    }

    @Override
    public EmergenciaEntity update(EmergenciaEntity emergencia) {
        String sqlQuery = "UPDATE emergencia SET asunto = :asunto, descripcion = :descripcion, direccion = :direccion, fecha =:fecha, activa = :activa, id_institucion = :idInstitucion, region = :region, ubicacion = :ubicacion WHERE id_emergencia = :idEmergencia";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("idEmergencia", emergencia.getId_emergencia())
                    .addParameter("asunto", emergencia.getAsunto())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("direccion", emergencia.getDireccion())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("activa", emergencia.getActiva())
                    .addParameter("idInstitucion", emergencia.getId_institucion())
                    .addParameter("region", emergencia.getRegion())
                    .addParameter("ubicacion", emergencia.getUbicacion())
                    .executeUpdate();
            con.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return findById(emergencia.getId_emergencia());
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM emergencia WHERE id_emergencia = :idEmergencia";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idEmergencia", id)
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
