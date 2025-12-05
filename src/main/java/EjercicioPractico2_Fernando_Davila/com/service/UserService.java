package EjercicioPractico2_Fernando_Davila.com.service;

import EjercicioPractico2_Fernando_Davila.com.domain.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(Long id);
}
