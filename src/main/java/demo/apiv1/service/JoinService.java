package demo.apiv1.service;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;

public interface JoinService {

    // 회원가입
    User join(User user) throws UserException;

}
