package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.EmergenciaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.EmergenciaRepository;
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

    @Override
    public List<EmergenciaEntity> findAll() {
        List<EmergenciaEntity> emergencias = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.emergencia ORDER BY idEmergencia ASC";
        try (Connection con = sql2o.open()) {
            emergencias = con.createQuery(sqlQuery).executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado

        }
        return emergencias;
    }

    @Override
    public EmergenciaEntity create(EmergenciaEntity emergencia) {
        String sqlQuery = "INSERT INTO emergencia (id_emergencia, asunto, fecha, descripcion, direccion, activa,id_institucion) VALUES (:id_emergencia, :asunto, :fecha, :descripcion, :direccion, :activa, :id_institucion)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("asunto", emergencia.getAsunto())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("direccion", emergencia.getDireccion())
                    .addParameter("activa", emergencia.getActiva())
                    .addParameter("id_institucion", emergencia.getIdInstitucion())
                    .executeUpdate();
            con.commit();
        }
        return null;
    }

    @Override
    public EmergenciaEntity findById(Long id) {
        EmergenciaEntity emergencia = null;
        String sqlQuery = "SELECT * FROM emergencia WHERE id_emergencia = :id";
        try (Connection con = sql2o.open()) {
            emergencia = con.createQuery(sqlQuery).addParameter("entrada", id).executeAndFetch(EmergenciaEntity.class).get(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return emergencia;
    }

    @Override
    public EmergenciaEntity update(EmergenciaEntity emergencia) {
        String sqlQuery = "UPDATE emergencia SET asunto = :emergencia.getAsunto(), descripcion = :emergencia.getDescripcion(), direccion = :emergencia.getDireccion(), fecha =:emergencia.getFecha(), activa = :emergencia.getActiva(), id_institucion = :emergencia.getIdInstitucion() WHERE id_emergencia = :emergencia.getidEmergencia()";
        try (Connection con = sql2o.beginTransaction()) {

            con.createQuery(sqlQuery)
                    .addParameter("idEmergencia", emergencia.getIdEmergencia())
                    .addParameter("asunto", emergencia.getAsunto())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("direccion", emergencia.getDireccion())
                    .addParameter("activa", emergencia.getActiva())
                    .addParameter("idInstitucion", emergencia.getIdInstitucion())
                    .executeUpdate();
            con.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return findById(emergencia.getIdEmergencia());
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM emergencia WHERE idEmergencia = :id";
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
