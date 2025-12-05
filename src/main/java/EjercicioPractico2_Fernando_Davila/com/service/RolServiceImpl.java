package EjercicioPractico2_Fernando_Davila.com.service;

import EjercicioPractico2_Fernando_Davila.com.domain.Rol;
import EjercicioPractico2_Fernando_Davila.com.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository repo;

    public RolServiceImpl(RolRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Rol> findAll() {
        return repo.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        repo.save(rol);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
