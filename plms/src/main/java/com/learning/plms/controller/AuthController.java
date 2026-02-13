package com.learning.plms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.learning.plms.model.Student;
import com.learning.plms.service.StudentService;

@Controller
public class AuthController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Student student) {
        service.register(student);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        Student student = service.login(email, password);

        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("courses",
                    service.recommend(student.getInterest()));
            return "dashboard";
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }
}
