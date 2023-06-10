package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.entities.Vol_HabilidadEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.Vol_HabilidadRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vol_habilidades")
public class Vol_HabilidadController {
    @Autowired
    private Vol_HabilidadRepositoryImpl vol_habilidadRepository;

    @GetMapping
    public ResponseEntity<List<Vol_HabilidadEntity>> findAll() {
        List<Vol_HabilidadEntity> vol_habilidades = vol_habilidadRepository.findAll();
        return new ResponseEntity<>(vol_habilidades, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Vol_HabilidadEntity> findById(@PathVariable Long id) {
        Vol_HabilidadEntity vol_habilidad = vol_habilidadRepository.findById(id);
        if (vol_habilidad != null) {
            return new ResponseEntity<>(vol_habilidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Vol_HabilidadEntity vol_habilidad) {
        vol_habilidadRepository.create(vol_habilidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Vol_HabilidadEntity vol_habilidad) {
        vol_habilidad.setIdVolHabilidad(id);
        vol_habilidadRepository.update(vol_habilidad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vol_habilidadRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
