package demo.apiv1.repository;

import demo.apiv1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findOptionalByUsername(String username);
    Boolean findBooleanByUsername(String username);
}
