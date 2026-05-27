package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/category")
    public String categoryPage() {

        return "category";

    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category) {

        service.saveCategory(category);

        return "redirect:/category";

    }

}