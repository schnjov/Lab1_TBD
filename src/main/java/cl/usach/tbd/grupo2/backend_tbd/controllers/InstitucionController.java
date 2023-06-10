package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.InstitucionEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.InstitucionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituciones")
public class InstitucionController {
    @Autowired
    private InstitucionRepositoryImpl institucionRepository;

    @GetMapping
    public ResponseEntity<List<InstitucionEntity>> findAll() {
        List<InstitucionEntity> instituciones = institucionRepository.findAll();
        return new ResponseEntity<>(instituciones, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<InstitucionEntity> findById(@PathVariable Long id) {
        InstitucionEntity institucion = institucionRepository.findById(id);
        if (institucion != null) {
            return new ResponseEntity<>(institucion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody InstitucionEntity institucion) {
        institucionRepository.create(institucion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody InstitucionEntity institucion) {
        institucion.setIdInstitucion(id);
        institucionRepository.update(institucion);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        institucionRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
