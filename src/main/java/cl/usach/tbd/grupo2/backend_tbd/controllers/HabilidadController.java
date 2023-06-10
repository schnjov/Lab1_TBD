package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.HabilidadRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    private HabilidadRepositoryImpl habilidadRepository;

    @GetMapping
    public ResponseEntity<List<HabilidadEntity>> findAll() {
        List<HabilidadEntity> habilidades = habilidadRepository.findAll();
        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadEntity> findById(@PathVariable Long id) {
        HabilidadEntity habilidad = habilidadRepository.findById(id);
        if (habilidad != null) {
            return new ResponseEntity<>(habilidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody HabilidadEntity habilidad) {
        habilidadRepository.create(habilidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody HabilidadEntity habilidad) {
        habilidad.setIdHabilidad(id);
        habilidadRepository.update(habilidad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habilidadRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
