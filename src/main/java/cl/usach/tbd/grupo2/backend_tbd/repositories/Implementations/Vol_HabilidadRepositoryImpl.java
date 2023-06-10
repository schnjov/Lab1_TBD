package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.Vol_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Vol_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Vol_HabilidadRepositoryImpl implements Vol_HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Vol_HabilidadEntity> findAll() {
        List<Vol_HabilidadEntity> vol_habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.vol_habilidad ORDER BY idVolHabilidad ASC";
        try (Connection con = sql2o.open()) {
            vol_habilidades = con.createQuery(sqlQuery).executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado

        }
        return vol_habilidades;
    }

    @Override
    public void create(Vol_HabilidadEntity vol_habilidad) {
        String sqlQuery = "INSERT INTO vol_habilidad (idVolHabilidad, idVoluntario, idHabilidad) VALUES (:id_vol_habilidad, :id_voluntario, :id_habilidad)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("id_vol_habilidad", vol_habilidad.getIdVolHabilidad())
                    .addParameter("id_voluntario", vol_habilidad.getIdVoluntario())
                    .addParameter("id_habilidad", vol_habilidad.getIdHabilidad())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public Vol_HabilidadEntity findById(Long id) {
        Vol_HabilidadEntity vol_habilidad = null;
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id";
        try (Connection con = sql2o.open()) {
            vol_habilidad = con.createQuery(sqlQuery).addParameter("entrada", id).executeAndFetch(Vol_HabilidadEntity.class).get(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return vol_habilidad;
    }

    @Override
    public List<Vol_HabilidadEntity> findByIdVoluntario(Long idVoluntario) {
        List<Vol_HabilidadEntity> vol_habilidades = null;
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_voluntario = :id";
        try (Connection con = sql2o.open()) {
            vol_habilidades = con.createQuery(sqlQuery).addParameter("id", idVoluntario).executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return vol_habilidades;
    }

    @Override
    public List<Vol_HabilidadEntity> findByIdHabilidad(Long idHabilidad) {
        List<Vol_HabilidadEntity> vol_habilidades = null;
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_habilidad = :id";
        try (Connection con = sql2o.open()) {
            vol_habilidades = con.createQuery(sqlQuery).addParameter("id", idHabilidad).executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return vol_habilidades;
    }

    @Override
    public void update(Vol_HabilidadEntity vol_habilidad) {
        String sqlQuery = "UPDATE vol_habilidad SET idVoluntario = :id_voluntario, idHabilidad = :id_habilidad WHERE idVolHabilidad = :id_vol_habilidad";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("id_voluntario", vol_habilidad.getIdVoluntario())
                    .addParameter("id_habilidad", vol_habilidad.getIdHabilidad())
                    .addParameter("id_vol_habilidad", vol_habilidad.getIdVolHabilidad())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM vol_habilidad WHERE idVolHabilidad = :id";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery).addParameter("id", id).executeUpdate();
            con.commit();
        }
    }

}
