package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;


import cl.usach.tbd.grupo2.backend_tbd.entities.HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadRepositoryImpl implements HabilidadRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<HabilidadEntity> findAll() {
        List<HabilidadEntity> habilidades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.habilidad ORDER BY id_habilidad ASC";
        try (Connection con = sql2o.open()){
            habilidades = con.createQuery(sqlQuery).executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);

        }
        return habilidades;
    }

    @Override
    public void create(HabilidadEntity habilidad) {
        String sqlQuery = "INSERT INTO habilidad (idHabilidad, Habilidad) VALUES (:habilidad.getIdHabilidad(), :habilidad.getHabilidad())";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idHabilidad", habilidad.getIdHabilidad())
                    .addParameter("Habilidad", habilidad.getHabilidad())
                    .executeUpdate();
            con.commit();
        } catch (Exception e) {
            // Conexion a sql ha fallado
            throw new RuntimeException(e);

        }

    }

    @Override
    public HabilidadEntity findById(Long id) {
        HabilidadEntity habilidad = null;
        String sqlQuery = "SELECT * FROM habilidad WHERE idHabilidad = :id";
        try (Connection con = sql2o.open()){
            habilidad = (HabilidadEntity)con.createQuery(sqlQuery).addParameter("idHabilidad", id).executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado//
            throw new RuntimeException(e);
        }
        return habilidad;
    }

    @Override
    public void update(HabilidadEntity habilidad) {

        String sqlQuery = "UPDATE habilidad SET Habilidad = :habilidad.getHabilidad() WHERE idHabilidad = :habilidad.getIdHabilidad()";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("id_habilidad", habilidad.getIdHabilidad())
                    .addParameter("nombre_habilidad", habilidad.getHabilidad())
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            // Conexion a sql ha fallado//
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM habilidad WHERE idHabilidad = :id";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idHabilidad", id)
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            // Conexion a sql ha fallado//
            throw new RuntimeException(e);
        }

    }
}
