package demo.apiv1.controller;

import demo.apiv1.domain.User;
import demo.apiv1.domain.response.ResponseDTO;
import demo.apiv1.domain.userForm.UserForm;
import demo.apiv1.exception.UserException;
import demo.apiv1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> join(@RequestBody UserForm userForm) throws UserException {
        try {
            log.info("UserController.signup");

            // dto -> entity
            User userEntity = UserForm.toEntity(userForm);

            // 유저 가입
            User registeredUser = userService.join(userEntity);

            // entity -> dto
            UserForm userDto = new UserForm(registeredUser);

            // 임시
            List<UserForm> userForms = new ArrayList<>();
            userForms.add(userDto);

            return ResponseEntity.ok().body(
                    ResponseDTO.<UserForm>builder().data(userForms).build()
            );
        } catch (UserException e) {
            return ResponseEntity.status(e.getErrCode()).body(
                    ResponseDTO.<UserForm>builder().error(e.getMessage()).build()
            );
        }

    }
}
