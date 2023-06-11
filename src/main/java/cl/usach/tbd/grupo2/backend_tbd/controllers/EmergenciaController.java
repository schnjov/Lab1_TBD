package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.EmergenciaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.EmergenciaRepositoryImpl;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.TareaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
public class EmergenciaController {
    @Autowired
    private EmergenciaRepositoryImpl emergenciaRepository;

    @Autowired
    private TareaRepositoryImpl tareaRepository;

    @GetMapping
    public ResponseEntity<List<EmergenciaEntity>> findAll() {
        List<EmergenciaEntity> emergencias = emergenciaRepository.findAll();
        return new ResponseEntity<>(emergencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergenciaEntity> findById(@PathVariable Long id) {
        EmergenciaEntity emergencia = emergenciaRepository.findById(id);
        if (emergencia != null) {
            return new ResponseEntity<>(emergencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idEmergencia}/count_tareas_activas")
    public ResponseEntity<Integer> countTareasActivasByEmergencia(@PathVariable Long idEmergencia) {
        int count = tareaRepository.countTareasActivasByEmergencia(idEmergencia);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EmergenciaEntity emergencia) {
        emergenciaRepository.create(emergencia);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody EmergenciaEntity emergencia) {
        emergencia.setIdEmergencia(id);
        emergenciaRepository.update(emergencia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emergenciaRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
