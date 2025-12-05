package EjercicioPractico2_Fernando_Davila.com;

import EjercicioPractico2_Fernando_Davila.com.domain.User;
import EjercicioPractico2_Fernando_Davila.com.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        String roleName = user.getRol() != null ? user.getRol().getNombre() : "ESTUDIANTE";
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + roleName));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}
