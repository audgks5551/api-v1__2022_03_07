package demo.apiv1.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import demo.apiv1.api.form.UserForm;
import demo.apiv1.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TokenProvider {

    private static final String SECRET_KEY = "SECRET_KEY";

    public String create(UserForm userForm) {
        System.out.println(System.currentTimeMillis());
        return JWT.create()
                .withSubject("token_test")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10)))
                .withClaim("username", userForm.getUsername())
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }
}
