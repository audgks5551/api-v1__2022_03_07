package demo.apiv1.service.join;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;
import demo.apiv1.repository.UserRepository;
import demo.apiv1.service.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class JoinServiceImpl1Test {

    @Autowired
    public JoinService joinService;

    @Test
    public void join() throws UserException {
        User user = new User("sample1", "password", "mark");

        User joinedUser = joinService.join(user);

        assertThat(joinedUser.getId()).isEqualTo(user.getId());
        assertThat(joinedUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(joinedUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(joinedUser.getName()).isEqualTo(user.getName());
    }

}