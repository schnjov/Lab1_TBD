package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.Tarea_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.Tarea_HabilidadRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea_habilidades")
public class Tarea_HabilidadController {
    @Autowired
    private Tarea_HabilidadRepositoryImpl tarea_habilidadRepository;

    @GetMapping
    public ResponseEntity<List<Tarea_HabilidadEntity>> findAll() {
        List<Tarea_HabilidadEntity> tarea_habilidades = tarea_habilidadRepository.findAll();
        return new ResponseEntity<>(tarea_habilidades, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Tarea_HabilidadEntity> findById(@PathVariable Long id) {
        Tarea_HabilidadEntity tarea_habilidad = tarea_habilidadRepository.findById(id);
        if (tarea_habilidad != null) {
            return new ResponseEntity<>(tarea_habilidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idTarea/{idTarea}")
    public ResponseEntity<List<Tarea_HabilidadEntity>> findByIdTarea(@PathVariable Long idTarea) {
        List<Tarea_HabilidadEntity> tarea_habilidades = tarea_habilidadRepository.findByIdTarea(idTarea);
        if (tarea_habilidades != null && !tarea_habilidades.isEmpty()) {
            return new ResponseEntity<>(tarea_habilidades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idHabilidad/{idHabilidad}")
    public ResponseEntity<List<Tarea_HabilidadEntity>> findByIdHabilidad(@PathVariable Long idHabilidad) {
        List<Tarea_HabilidadEntity> tarea_habilidades = tarea_habilidadRepository.findByIdHabilidad(idHabilidad);
        if (tarea_habilidades != null && !tarea_habilidades.isEmpty()) {
            return new ResponseEntity<>(tarea_habilidades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Tarea_HabilidadEntity tarea_habilidad) {
        tarea_habilidadRepository.create(tarea_habilidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Tarea_HabilidadEntity tarea_habilidad) {
        tarea_habilidad.setIdTareaHabilidad(id);
        tarea_habilidadRepository.update(tarea_habilidad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarea_habilidadRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
