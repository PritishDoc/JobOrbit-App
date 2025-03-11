package com.joborbit.joborbit.controller;

import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.entity.UsersType;
import com.joborbit.joborbit.services.UserTypeService;
import com.joborbit.joborbit.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")  // Group all user-related endpoints
public class UsersController {

    private final UserTypeService userTypeService;
    private final UsersService usersService;

    public UsersController(UserTypeService userTypeService, UsersService usersService) {
        this.userTypeService = userTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = userTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@ModelAttribute("user") Users users, Model model) {
        if (usersService.emailExists(users.getEmail())) {
            model.addAttribute("error", "Email is already registered. Try logging in or using a different email.");
            List<UsersType> usersTypes = userTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);
        return "redirect:/users/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
