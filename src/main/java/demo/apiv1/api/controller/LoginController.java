package demo.apiv1.api.controller;

import demo.apiv1.api.form.LoginForm;
import demo.apiv1.api.form.UserForm;
import demo.apiv1.api.response.ResponseDTO;
import demo.apiv1.util.KeycloakUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    private final KeycloakUtil keycloakUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginForm loginForm) {
        AccessTokenResponse token = keycloakUtil.getToken(loginForm);

        return ResponseEntity.ok().body(
                ResponseDTO.builder().data(token).build()
        );
    }
}
