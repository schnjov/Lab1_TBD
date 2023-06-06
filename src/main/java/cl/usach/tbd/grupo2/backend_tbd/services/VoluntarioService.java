package cl.usach.tbd.grupo2.backend_tbd.services;

import cl.usach.tbd.grupo2.backend_tbd.entities.VoluntarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.Implementations.VoluntarioRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    private final VoluntarioRepositoryImpl voluntarioRepository;

    public VoluntarioService(VoluntarioRepositoryImpl voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public List<VoluntarioEntity> findAll() {
        return voluntarioRepository.findAll();
    }

    public VoluntarioEntity findById(Long id) {
        return voluntarioRepository.findById(id);
    }

    public void create(VoluntarioEntity voluntario) {
        voluntarioRepository.create(voluntario);
    }

    public void update(VoluntarioEntity voluntario) {
        voluntarioRepository.update(voluntario);
    }

    public void delete(Long id) {
        voluntarioRepository.delete(id);
    }
}
