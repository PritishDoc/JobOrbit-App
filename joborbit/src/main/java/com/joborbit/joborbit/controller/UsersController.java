package com.joborbit.joborbit.controller;

import com.joborbit.joborbit.entity.UsersType;
import com.joborbit.joborbit.services.UserTypeService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    private final UserTypeService userTypeService;
@Autowired
    public UsersController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }
    @GetMapping("/register")
    public String register(Model model){
    List<UsersType>usersTypes=usersTypeService.getAll();
    model.addAttribute("getAllTypes",usersTypes);
    model.addAttribute("user",new Users());
    return "register":
    }
}
