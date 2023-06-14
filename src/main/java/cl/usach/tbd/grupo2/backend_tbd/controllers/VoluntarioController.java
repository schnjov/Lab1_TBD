package cl.usach.tbd.grupo2.backend_tbd.controllers;


import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.VoluntarioRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final VoluntarioRepositoryImpl voluntarioRepository;

    public VoluntarioController(VoluntarioRepositoryImpl voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioEntity>> findAll() {
        List<VoluntarioEntity> voluntarios = voluntarioRepository.findAll();
        return new ResponseEntity<>(voluntarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioEntity> findById(@PathVariable Long id) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id);
        if (voluntario != null) {
            return new ResponseEntity<>(voluntario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ratio")
    public ResponseEntity<List<VoluntarioEntity>> findByEmergenciaAndRadio(@RequestParam("emergencia") Long idEmergencia, @RequestParam("radio") Double radio) {
        List<VoluntarioEntity> volunteers = voluntarioRepository.findByEmergenciaAndRadio(idEmergencia, radio);
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody VoluntarioEntity voluntario) {
        voluntarioRepository.create(voluntario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody VoluntarioEntity voluntario) {
        voluntario.setId(id);
        voluntarioRepository.update(voluntario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        voluntarioRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
