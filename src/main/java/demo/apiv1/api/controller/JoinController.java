package demo.apiv1.api.controller;

import demo.apiv1.domain.User;
import demo.apiv1.api.response.ResponseDTO;
import demo.apiv1.api.form.UserForm;
import demo.apiv1.exception.UserException;
import demo.apiv1.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * TODO
 *  1. 테스트하기
 */
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class JoinController{
    
    private final JoinService joinService;

    @PostMapping
    public ResponseEntity<?> join(@RequestBody UserForm userForm) throws UserException {
        try {
            log.info("UserController.signup");

            // dto -> entity
            User userEntity = UserForm.toEntity(userForm);

            // 유저 가입
            User registeredUser = joinService.join(userEntity);

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
