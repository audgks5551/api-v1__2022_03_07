package demo.apiv1;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * TODO
 *  1. keycloak에도 회원가입 구현
 *  2. 로그인시 keycloak에서 토큰받아와 전달
 */
@SpringBootApplication
public class ApiV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiV1Application.class, args);
	}

	@Bean
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}
}
