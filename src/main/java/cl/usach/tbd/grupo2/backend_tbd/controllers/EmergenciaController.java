package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.EmergenciaEntity;
import cl.usach.tbd.grupo2.backend_tbd.entities.TareaEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.EmergenciaRepositoryImpl;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.TareaRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/emergencias")
public class EmergenciaController {
    @Autowired
    private EmergenciaRepositoryImpl emergenciaRepository;

    private final Logger logger = LoggerFactory.getLogger(EmergenciaController.class);
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

    @GetMapping("/byTarea/{tareaId}")
    public ResponseEntity<EmergenciaEntity> findByTarea(@PathVariable Long tareaId) {
        EmergenciaEntity emergencia = emergenciaRepository.findByTarea(tareaId);

        if (emergencia != null) {
            return new ResponseEntity<>(emergencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EmergenciaEntity emergencia) {
        emergenciaRepository.create(emergencia);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody EmergenciaEntity emergencia) {
        emergencia.setId_emergencia(id);
        emergenciaRepository.update(emergencia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/cambiar/estado/{id}")
        public ResponseEntity<Void> cambiarEstado(@PathVariable Long id) {
        emergenciaRepository.cambiarEstado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Integer> countTareasByEmergencia(@PathVariable Long id) {
        int count = emergenciaRepository.countTareasByEmergencia(id);
        logger.info("count: " + count);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emergenciaRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
