package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.TareaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.TareaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaRepositoryImpl tareaRepository;

    @GetMapping
    public ResponseEntity<List<TareaEntity>> findAll() {
        List<TareaEntity> tareas = tareaRepository.findAll();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<TareaEntity> findById(@PathVariable Long id) {
        TareaEntity tarea = tareaRepository.findById(id);
        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idEmergencia")
    public ResponseEntity<List<TareaEntity>> findByIdEmergencia(@PathVariable Long id) {
        List<TareaEntity> tareas = tareaRepository.findByIdEmergencia(id);
        if (tareas != null) {
            return new ResponseEntity<>(tareas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TareaEntity tarea) {
        tareaRepository.create(tarea);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TareaEntity tarea) {
        tarea.setIdTarea(id);
        tareaRepository.update(tarea);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tareaRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
