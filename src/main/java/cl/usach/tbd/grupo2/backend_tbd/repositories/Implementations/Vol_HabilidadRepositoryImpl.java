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
        String sqlQuery = "SELECT * FROM vol_habilidad ORDER BY id_vol_habilidad ASC";
        try (Connection con = sql2o.open()) {
            vol_habilidades = con.createQuery(sqlQuery).executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
        }
        return vol_habilidades;
    }

    @Override
    public void create(Vol_HabilidadEntity volHabilidad) {
        String sqlQuery = "INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (:idVolHabilidad, :idVoluntario, :idHabilidad)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlQuery)
                    .addParameter("idVolHabilidad", volHabilidad.getIdVolHabilidad())
                    .addParameter("idVoluntario", volHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", volHabilidad.getIdHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public Vol_HabilidadEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
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
    public void update(Vol_HabilidadEntity volHabilidad) {
        String sqlQuery = "UPDATE vol_habilidad SET id_voluntario = :idVoluntario, id_habilidad = :idHabilidad WHERE id_vol_habilidad = :idVolHabilidad";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlQuery)
                    .addParameter("idVoluntario", volHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", volHabilidad.getIdHabilidad())
                    .addParameter("idVolHabilidad", volHabilidad.getIdVolHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM vol_habilidad WHERE id_vol_habilidad = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
