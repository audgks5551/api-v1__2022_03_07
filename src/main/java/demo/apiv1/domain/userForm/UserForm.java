package demo.apiv1.domain.userForm;

import demo.apiv1.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForm {
    private String username;
    private String password;
    private String name;

    // User -> UserForm
    public UserForm(final User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
    }

    // UserForm -> User
    public static User toEntity(final UserForm userForm) {
        return new User(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getName()
        );
    }
}
