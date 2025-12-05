package EjercicioPractico2_Fernando_Davila.com.repository;

import EjercicioPractico2_Fernando_Davila.com.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);

}
