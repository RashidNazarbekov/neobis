package kg.neobis.cardealership.security.domain;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String email;
    private String phone;

    public User toUser(BCryptPasswordEncoder bCryptPasswordEncoder) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        return user;
    }
}
