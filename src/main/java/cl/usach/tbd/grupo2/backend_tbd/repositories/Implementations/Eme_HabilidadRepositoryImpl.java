package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.Eme_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Eme_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.ArrayList;

@Repository
public class Eme_HabilidadRepositoryImpl implements Eme_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Eme_HabilidadEntity> findAll() {
        List<Eme_HabilidadEntity> eme_habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM eme_habilidad ORDER BY id_eme_habilidad ASC";
        try (Connection con = sql2o.open()) {
            eme_habilidades = con.createQuery(sqlQuery).executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado

        }
        return eme_habilidades;
    }

    @Override
    public void create(Eme_HabilidadEntity eme_habilidad) {
        String sqlQuery = "INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (:idEmeHabilidad, :idEmergencia, :idHabilidad)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("idEmeHabilidad", eme_habilidad.getIdEmeHabilidad())
                    .addParameter("idEmergencia", eme_habilidad.getIdEmergencia())
                    .addParameter("idHabilidad", eme_habilidad.getIdHabilidad())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Eme_HabilidadEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM eme_habilidad WHERE id_eme_habilidad = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public List<Eme_HabilidadEntity> findByIdEmergencia(Long idEmergencia) {
        List<Eme_HabilidadEntity> eme_habilidades = null;
        String sqlQuery = "SELECT * FROM eme_habilidad WHERE id_emergencia = :id";
        try (Connection con = sql2o.open()) {
            eme_habilidades = con.createQuery(sqlQuery).addParameter("id", idEmergencia).executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return eme_habilidades;
    }

    @Override
    public List<Eme_HabilidadEntity> findByIdHabilidad(Long idHabilidad) {
        List<Eme_HabilidadEntity> eme_habilidades = null;
        String sqlQuery = "SELECT * FROM eme_habilidad WHERE id_habilidad = :id";
        try (Connection con = sql2o.open()) {
            eme_habilidades = con.createQuery(sqlQuery).addParameter("id", idHabilidad).executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return eme_habilidades;
    }


    @Override
    public void update(Eme_HabilidadEntity eme_habilidad) {
        String sqlQuery = "UPDATE eme_habilidad SET id_emergencia = :idEmergencia, id_habilidad = :idHabilidad WHERE id_eme_habilidad = :idEmeHabilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idEmergencia", eme_habilidad.getIdEmergencia())
                    .addParameter("idHabilidad", eme_habilidad.getIdHabilidad())
                    .addParameter("idEmeHabilidad", eme_habilidad.getIdEmeHabilidad())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM eme_habilidad WHERE id_eme_habilidad = :id";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery).addParameter("id", id).executeUpdate();
            con.commit();
        }
    }

}
