package com.joborbit.joborbit.controller;

import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.entity.UsersType;
import com.joborbit.joborbit.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UserTypeService userTypeService;

    @Autowired
    public UsersController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = userTypeService.getAll();  // Fixed variable name
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register"; // Fixed return statement
    }
}
