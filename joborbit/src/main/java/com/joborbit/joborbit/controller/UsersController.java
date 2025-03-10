package com.joborbit.joborbit.controller;

import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.entity.UsersType;
import com.joborbit.joborbit.services.UserTypeService;
import com.joborbit.joborbit.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UserTypeService userTypeService;
    private final UsersService usersService;

    @Autowired
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
    public String userRegistration(@Valid @ModelAttribute("user") Users users) {
        System.out.println("User: " + users);
        usersService.addNew(users);  // No casting needed
        return "redirect:/dashboard";  // Redirect to dashboard after successful registration
    }
}
