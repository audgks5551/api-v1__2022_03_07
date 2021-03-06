package demo.apiv1.service.join;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;
import demo.apiv1.repository.UserRepository;
import demo.apiv1.service.JoinService;
import demo.apiv1.util.KeycloakUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinServiceImpl1 implements JoinService {

    private final UserRepository userRepository;
    private final KeycloakUtil keycloakUtil;

    public User join(User user) throws UserException {
        if (userRepository.findOptionalByUsername(user.getUsername()).isPresent()) {
            throw new UserException("이미 가입된 유저입니다", 409);
        }

        User savedUser = userRepository.save(user);
        keycloakUtil.registerUser(savedUser);

        return savedUser;
    }
}
