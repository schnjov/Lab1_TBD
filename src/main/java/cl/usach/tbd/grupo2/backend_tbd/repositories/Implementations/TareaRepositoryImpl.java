package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.TareaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.TareaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TareaRepositoryImpl implements TareaRepository {

    @Autowired
    private Sql2o sql2o;
    @Override
    public void create(TareaEntity tarea) {

        String sqlQuery = "INSERT INTO tarea (idTarea, asuntoTarea, idEmergencia, idEstadoTarea) VALUES (:tarea.getIdTarea(), :tarea.getAsuntoTarea(), :tarea.getIdEmergencia(), :tarea.getIdEstadoTarea())";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idTarea", tarea.getIdTarea())
                    .addParameter("asuntoTarea", tarea.getAsuntoTarea())
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("idEstadoTarea", tarea.getIdEstadoTarea())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public List<TareaEntity> findAll() {
        List<TareaEntity> tareas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.tarea ORDER BY idTarea ASC";
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
        String sqlQuery = "SELECT * FROM tarea WHERE idTarea = :id";
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
        String sqlQuery = "SELECT * FROM tarea WHERE tarea.idEmergencia = :id";
        try (Connection con = sql2o.open()){
            tareas = con.createQuery(sqlQuery).addParameter("idEmergencia", id).executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);
        }
        return tareas;
    }

    @Override
    public void update(TareaEntity tarea) {
        String sqlQuery = "UPDATE tarea SET asuntoTarea = : tarea.getAsuntoTarea(), idEmergencia= :tarea.getIdEmergencia(), idEstadoTarea = :tarea.getIdEstadoTarea() WHERE idTarea = :tarea.getIdTarea()";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idTarea", tarea.getIdTarea())
                    .addParameter("asuntoTarea", tarea.getAsuntoTarea())
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("idEstadoTarea", tarea.getIdEstadoTarea())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM tarea WHERE idTarea = :id";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idTarea", id)
                    .executeUpdate();
            con.commit();
        }

    }
}
