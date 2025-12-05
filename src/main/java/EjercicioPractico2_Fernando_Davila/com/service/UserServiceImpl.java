package EjercicioPractico2_Fernando_Davila.com.service;

import EjercicioPractico2_Fernando_Davila.com.domain.User;
import EjercicioPractico2_Fernando_Davila.com.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
