package demo.apiv1.service.join;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;
import demo.apiv1.repository.UserRepository;
import demo.apiv1.service.JoinService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Rollback(false)
class JoinServiceImpl1Test {

    @Autowired
    private JoinService joinService;
    @Autowired
    private UserRepository userRepository;

    private User user = null;

    @BeforeEach
    public void init() {
        user = new User("sample1", "password", "mark");
    }

    @AfterEach
    public void removeAll() {
        userRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("회원가입_테스트")
    public void join() throws UserException {
        User joinedUser = joinService.join(user);

        assertThat(joinedUser.getId()).isEqualTo(user.getId());
        assertThat(joinedUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(joinedUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(joinedUser.getName()).isEqualTo(user.getName());
    }

    @Test
    public void 아이디_중복_예외() {
        assertThatThrownBy(() -> {
            joinService.join(user);
            joinService.join(user);
        })
                .isInstanceOf(UserException.class);

        UserException exception = assertThrows(UserException.class, () -> {
            joinService.join(user);
        });

        assertThat("이미 가입된 유저입니다").isEqualTo(exception.getMessage());
        assertThat(409).isEqualTo(exception.getErrCode());
    }
}