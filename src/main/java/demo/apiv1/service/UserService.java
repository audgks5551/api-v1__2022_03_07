package demo.apiv1.service;

import demo.apiv1.domain.User;
import demo.apiv1.exception.UserException;

public interface UserService {
    User join(User user) throws UserException;
}
