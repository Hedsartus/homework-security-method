package ru.netology.homeworksecuritymethod;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.netology.homeworksecuritymethod.enums.Role;
import ru.netology.homeworksecuritymethod.model.User;
import ru.netology.homeworksecuritymethod.repository.UserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class HomeworkSecurityMethodApplication implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSecurityMethodApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setEmail("admin@mail.ru");
        admin.setPassword(passwordEncoder.encode("password1"));
        admin.setName("Admin");
        admin.setActive(true);
        admin.getRoles().add(Role.ROLE_READ);
        admin.getRoles().add(Role.ROLE_WRITE);
        admin.getRoles().add(Role.ROLE_DELETE);
        userRepository.save(admin);

        User user = new User();
        user.setEmail("vasya@mail.ru");
        user.setPassword(passwordEncoder.encode("password2"));
        user.setName("Vasya");
        user.setActive(true);
        user.getRoles().add(Role.ROLE_WRITE);
        userRepository.save(user);

        User user1 = new User();
        user1.setEmail("kolya@mail.ru");
        user1.setPassword(passwordEncoder.encode("password3"));
        user1.setName("Kolya");
        user1.setActive(true);
        user1.getRoles().add(Role.ROLE_READ);
        userRepository.save(user1);
    }
}
