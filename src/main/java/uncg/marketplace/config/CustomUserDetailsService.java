package uncg.marketplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import uncg.marketplace.entity.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uncg.marketplace.repository.UserRepository;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<User> user = repository.findByEmail(email);

        return user.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user was not found"));
    }
}
