package com.example.springalishev.bootProject.controllers;



import com.example.springalishev.bootProject.models.User;
import com.example.springalishev.bootProject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {



//    @Autowired
//    private UserService userService;


    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "/show";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user",new User());
        return "/new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/people/list";
    }


    @GetMapping("/people/list")
    public String getListUser(Model model) {
        List<User> userList = userService.index();
        model.addAttribute("userList",userList);
        return "/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user",userService.show(id));
        return "/edit";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id,user);
        return "redirect:/people/list";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/people/list";
    }

}
