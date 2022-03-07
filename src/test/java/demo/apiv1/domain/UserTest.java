package demo.apiv1.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class UserTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void 유저_생성() {
        User user1 = new User("sample1", "password", "mark");
        User user2 = new User("sample2", "password", "spring");
        User user3 = new User("sample3", "password", "boot");
        User user4 = new User("sample4", "password", "test");


        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);

        em.flush();
        em.clear();

        List<User> users = em.createQuery("select u from User u", User.class).getResultList();

        assertThat(users.size()).isEqualTo(4);
    }
}