package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    UserRepository repo;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        User user = repo.findByUsernameAndPassword(username, password);

        if(user != null) {

            session.setAttribute("user", user);

            return "redirect:/";
        }

        model.addAttribute("msg", "Invalid Username or Password");

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}