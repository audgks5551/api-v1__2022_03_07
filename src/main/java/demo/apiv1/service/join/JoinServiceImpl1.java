package demo.apiv1.service.join;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;
import demo.apiv1.repository.UserRepository;
import demo.apiv1.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TODO
 *  1. join() 테스트하기
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JoinServiceImpl1 implements JoinService {

    private final UserRepository userRepository;

    public User join(User user) throws UserException {
        // 회원가입 아이디의 중복이 있는지 확인
        if (!userRepository.findByUsername(user.getUsername()).isEmpty()) {
            log.warn("이미 가입된 유저입니다");
            throw new UserException("이미 가입된 유저입니다", 409);
         }

        return userRepository.save(user);
    }
}
