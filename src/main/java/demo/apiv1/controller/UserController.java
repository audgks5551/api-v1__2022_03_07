package demo.apiv1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String signupForm() {
        log.info("signupForm");
        return "signup";
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String signup() {
        log.info("signup");
        return "ok";
    }
}
