package EjercicioPractico2_Fernando_Davila.com.service;

import EjercicioPractico2_Fernando_Davila.com.domain.Rol;
import java.util.List;

public interface RolService {
    List<Rol> findAll();
    Rol findById(Long id);
    void save(Rol rol);
    void delete(Long id);
}
