package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.Eme_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.Eme_HabilidadRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eme_habilidades")
public class Eme_HabilidadController {
    @Autowired
    private Eme_HabilidadRepositoryImpl eme_habilidadRepository;

    @GetMapping
    public ResponseEntity<List<Eme_HabilidadEntity>> findAll() {
        List<Eme_HabilidadEntity> eme_habilidades = eme_habilidadRepository.findAll();
        return new ResponseEntity<>(eme_habilidades, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Eme_HabilidadEntity> findById(@PathVariable Long id) {
        Eme_HabilidadEntity eme_habilidad = eme_habilidadRepository.findById(id);
        if (eme_habilidad != null) {
            return new ResponseEntity<>(eme_habilidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Eme_HabilidadEntity eme_habilidad) {
        eme_habilidadRepository.create(eme_habilidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Eme_HabilidadEntity eme_habilidad) {
        eme_habilidad.setIdEmeHabilidad(id);
        eme_habilidadRepository.update(eme_habilidad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eme_habilidadRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
