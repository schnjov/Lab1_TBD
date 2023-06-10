package cl.usach.tbd.grupo2.backend_tbd.repositories;

import cl.usach.tbd.grupo2.backend_tbd.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {
    public List<RankingEntity> findAll();
    public List<RankingEntity> findByIdTarea(Long id);
    public void create(RankingEntity reanking);
    public void delete(Long id);
    public void update(RankingEntity ranking);
    public RankingEntity findById(Long id);

}
