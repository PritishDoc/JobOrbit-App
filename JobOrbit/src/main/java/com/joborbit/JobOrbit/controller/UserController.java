package com.joborbit.JobOrbit.controller;

import com.joborbit.JobOrbit.Entity.Users;
import com.joborbit.JobOrbit.Entity.UsersType;
import com.joborbit.JobOrbit.services.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // ✅ Correct import
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UsersTypeService usersTypeService;

    @Autowired
    public UserController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }
}
