package demo.apiv1.service;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;
import demo.apiv1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User join(User user) throws UserException {
        // 회원가입 아이디의 중복이 있는지 확인
        if (userRepository.findByUsername(user.getUsername()) != null) {
            log.warn("이미 가입된 유저입니다");
            throw new UserException("이미 가입된 유저입니다", 409);
         }

        return userRepository.save(user);
    }
}