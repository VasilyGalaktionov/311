package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers (Model model) {
        model.addAttribute("users",userService.allUsers());
        return "allUsers";
    }
    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getById(id));
        return "show";
    }
    @GetMapping("/new")
    public String newUser( Model model){
        model.addAttribute("user",new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.add(user);
            return "redirect:/";
        }
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getById(id));
        return "edit";
    }
    @PatchMapping (value = "/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.edit(user);
            return "redirect:/";
        }
    }
    @GetMapping (value = "/delete/{id}")
    public String delete( @PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/";
    }
}