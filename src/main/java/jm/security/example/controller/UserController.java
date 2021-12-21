package jm.security.example.controller;

import jm.security.example.model.User;
import jm.security.example.service.UserDetailsServiceImpl;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @GetMapping("/user")
    public String userByName(Model userModel) {
        userModel.addAttribute("user", userDetailsService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "user";
    }
    @GetMapping("/access_denied")
    public String acces() {

        return "access_denied";
    }
}