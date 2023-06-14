package cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations;

import cl.usach.tbd.grupo2.backend_tbd.entities.RankingEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RankingRepositoryImpl implements RankingRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<RankingEntity> findAll() {
        List<RankingEntity> rankings = new ArrayList<>();
        String sqlQuery = "SELECT * FROM ranking ORDER BY id_ranking ASC";
        try (Connection con = sql2o.open()) {
            rankings = con.createQuery(sqlQuery).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            // Conexion a sql ha fallado

        }
        return rankings;
    }

    @Override
    public List<RankingEntity> findByIdTarea(Long id) {
        List<RankingEntity> ranking = null;
        String sqlQuery = "SELECT * FROM ranking WHERE id_tarea = :idTarea";
        try (Connection con = sql2o.open()) {
            ranking = con.createQuery(sqlQuery).addParameter("idTarea", id).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return ranking;
    }

    @Override
    public void create(RankingEntity ranking) {
        String sqlQuery = "INSERT INTO ranking (id_ranking, id_tarea, id_voluntario, puntaje) VALUES (:idRanking, :idTarea, :idVoluntario, :puntaje)";
        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(sqlQuery)
                    .addParameter("idRanking", ranking.getId_ranking())
                    .addParameter("idTarea", ranking.getId_tarea())
                    .addParameter("idVoluntario", ranking.getId_voluntario())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM ranking WHERE id_ranking = :idRanking";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idRanking", id)
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(RankingEntity ranking) {
        String sqlQuery = "UPDATE ranking SET id_tarea = :idTarea, id_voluntario = :idVoluntario, puntaje = :puntaje WHERE id_ranking = :idRanking";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(sqlQuery)
                    .addParameter("idRanking", ranking.getId_ranking())
                    .addParameter("idTarea", ranking.getId_tarea())
                    .addParameter("idVoluntario", ranking.getId_voluntario())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .executeUpdate();
            con.commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RankingEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM ranking WHERE id_ranking = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}