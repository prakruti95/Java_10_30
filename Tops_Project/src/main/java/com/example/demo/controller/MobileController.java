package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Mobile;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MobileRepository;

import jakarta.validation.Valid;

@Controller
public class MobileController {

    @Autowired
    MobileRepository repo;

    @Autowired
    BrandRepository brandRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping("/")
    public String home(Model model) {

        List<Mobile> list = repo.findAll();

        model.addAttribute("mobiles", list);

        return "index";
    }

    @GetMapping("/add")
    public String addPage(Model model) {

        model.addAttribute("mobile", new Mobile());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());

        return "addmobile";
    }

    @PostMapping("/save")
    public String saveMobile(@Valid @ModelAttribute("mobile") Mobile mobile,
                              BindingResult result,
                              Model model) {

        if(result.hasErrors()) {

            model.addAttribute("brands", brandRepo.findAll());
            model.addAttribute("categories", categoryRepo.findAll());

            return "addmobile";
        }

        repo.save(mobile);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteMobile(@PathVariable int id) {

        repo.deleteById(id);

        return "redirect:/";
    }
}