package uncg.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uncg.marketplace.entity.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);
}
