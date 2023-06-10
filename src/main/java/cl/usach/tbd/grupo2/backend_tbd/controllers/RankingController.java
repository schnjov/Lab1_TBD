package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.RankingEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.RankingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingRepositoryImpl rankingRepository;

    @GetMapping
    public ResponseEntity<List<RankingEntity>> findAll() {
        List<RankingEntity> rankings = rankingRepository.findAll();
        return new ResponseEntity<>(rankings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingEntity> findById(@PathVariable Long id) {
        RankingEntity ranking = rankingRepository.findById(id);
        if (ranking != null) {
            return new ResponseEntity<>(ranking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_tarea")
    public ResponseEntity<List<RankingEntity>> findByIdTarea(@PathVariable Long idTarea) {
        List<RankingEntity> ranking = rankingRepository.findByIdTarea(idTarea);
        if (ranking != null) {
            return new ResponseEntity<>(ranking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RankingEntity ranking) {
        rankingRepository.create(ranking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RankingEntity ranking) {
        ranking.setIdRanking(id);
        rankingRepository.update(ranking);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rankingRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
