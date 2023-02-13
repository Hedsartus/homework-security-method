package ru.netology.homeworksecuritymethod.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworksecuritymethod.model.User;
import ru.netology.homeworksecuritymethod.service.UserService;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMsg",
                    "Пользователь с email: " + user.getEmail() + " уже существует!");
            return "registration";
        }

        return "redirect:/login";
    }


    @GetMapping("/")
    public String getMain(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("user", userService.getUserByEmail(principal.getName()));
        } else {
            model.addAttribute("user", new User());
        }
        return "home";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/user")
    @PreAuthorize("#email == authentication.principal.username")
    public String named(@RequestParam String email, Model model) {
        model.addAttribute("name", userService.getUserByEmail(email).getName());
        return "user";
    }

    @PostAuthorize("hasAnyRole('ROLE_READ','ROLE_DELETE')")
    @GetMapping("/all-users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "all-users";
    }

    @Secured("ROLE_READ")
    @GetMapping("/users")
    public String viewAllUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "all-users";
    }
}
