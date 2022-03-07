package demo.apiv1.repository;

import demo.apiv1.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 유저_생성() {
        User user = new User("sample1", "password", "mark");
        User savedUser = userRepository.save(user);

        em.flush();
        em.clear();

        User findUser = userRepository.findById(savedUser.getId()).get();

        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(findUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(findUser.getName()).isEqualTo(user.getName());
        assertThat(findUser).isNotEqualTo(user);
    }
}