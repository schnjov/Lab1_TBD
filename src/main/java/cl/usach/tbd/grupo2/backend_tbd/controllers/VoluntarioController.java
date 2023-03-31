package cl.usach.tbd.grupo2.backend_tbd.controllers;


import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.services.VoluntarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioEntity>> findAll() {
        List<VoluntarioEntity> voluntarios = voluntarioService.findAll();
        return new ResponseEntity<>(voluntarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioEntity> findById(@PathVariable Long id) {
        VoluntarioEntity voluntario = voluntarioService.findById(id);
        if (voluntario != null) {
            return new ResponseEntity<>(voluntario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody VoluntarioEntity voluntario) {
        voluntarioService.create(voluntario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody VoluntarioEntity voluntario) {
        voluntario.setId(id);
        voluntarioService.update(voluntario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        voluntarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
