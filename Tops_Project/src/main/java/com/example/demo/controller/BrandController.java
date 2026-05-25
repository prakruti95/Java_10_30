package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;


@Controller
public class BrandController {

    @Autowired
    BrandService service;

    @GetMapping("/brand")
    public String brandPage() {
        return "brand";
    }

    @PostMapping("/saveBrand")
    public String saveBrand(@ModelAttribute Brand brand) {

        service.saveBrand(brand);

        return "redirect:/brand";
    }
}