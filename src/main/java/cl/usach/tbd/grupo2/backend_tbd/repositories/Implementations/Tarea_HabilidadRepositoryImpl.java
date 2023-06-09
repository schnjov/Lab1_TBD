package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.RankingEntity;
import cl.usach.tbd.grupo2.backend_tbd.entities.Tarea_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Tarea_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Tarea_HabilidadRepositoryImpl implements Tarea_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<Tarea_HabilidadEntity> findAll() {
        List<Tarea_HabilidadEntity> tareahabilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.tarea_habilidad ORDER BY idTareaHabilidad ASC";
        try (Connection con = sql2o.open()) {
            tareahabilidades = con.createQuery(sqlQuery).executeAndFetch(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado

        }
        return tareahabilidades;
    }

    @Override
    public void create(Tarea_HabilidadEntity tarea_habilidad) {
        String sqlQuery = "INSERT INTO ranking (idTareaHabilidad, idTarea, idHabilidad) VALUES (:id_tarea_habilidad, :id_tarea, :id_habilidad)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("id_tarea_habilidad", tarea_habilidad.getIdTareaHabilidad())
                    .addParameter("id_tarea", tarea_habilidad.getIdTarea())
                    .addParameter("id_habilidad", tarea_habilidad.getIdHabilidad())
                    .executeUpdate();
            con.commit();
        }
    }
    @Override
    public Tarea_HabilidadEntity findByIdTareaHabilidad(Long id) {
        Tarea_HabilidadEntity tareahabilidad = null;
        String sqlQuery = "SELECT * FROM tarea_habilidad WHERE id_tarea_habilidad = :id";
        try (Connection con = sql2o.open()) {
            tareahabilidad = con.createQuery(sqlQuery).addParameter("entrada", id).executeAndFetch(Tarea_HabilidadEntity.class).get(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return tareahabilidad;
    }


    @Override
    public void update(Tarea_HabilidadEntity tarea_habilidad) {
        String sqlQuery = "UPDATE ranking SET idTarea = :id_tarea, idHabilidad = :id_habilidad WHERE idTareaHabilidad = :id_tarea_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("id_tarea_habilidad", tarea_habilidad.getIdTareaHabilidad())
                    .addParameter("id_tarea", tarea_habilidad.getIdTarea())
                    .addParameter("id_habilidad", tarea_habilidad.getIdHabilidad())
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM tarea_habilidad WHERE id_tarea_habilidad = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlQuery).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
