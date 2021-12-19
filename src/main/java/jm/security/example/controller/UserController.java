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
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @PostMapping("/create")
    public String createOrUpdate(@ModelAttribute("new") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String giveAllUsers(Model userModel) {
        List<User> someUsers = userService.getAllUsers();
        userModel.addAttribute("users", someUsers);
        return "admin";
    }

    @GetMapping("/fill")
    public String fillUserParametrs(Model userModel) {
        User user = new User();
        userModel.addAttribute("user", user);
        return "create&UpdateNewUser";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model userModel) {
        User user = userService.fiendUserById(id);
        userModel.addAttribute("user", user);
        return "create&UpdateNewUser";
    }

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