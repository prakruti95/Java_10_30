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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MobileController {

    @Autowired
    MobileRepository repo;

    @Autowired
    BrandRepository brandRepo;

    @Autowired
    CategoryRepository categoryRepo;

    // HOME PAGE
    @GetMapping("/")
    public String home(Model model, HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Mobile> list = repo.findAll();

        model.addAttribute("mobiles", list);

        return "index";
    }

    // ADD MOBILE PAGE
    @GetMapping("/add")
    public String addPage(Model model, HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("mobile", new Mobile());

        model.addAttribute("brands", brandRepo.findAll());

        model.addAttribute("categories", categoryRepo.findAll());

        return "addmobile";
    }

    // SAVE MOBILE
    @PostMapping("/save")
    public String saveMobile(
            @Valid @ModelAttribute("mobile") Mobile mobile,
            BindingResult result,
            Model model,
            HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // Validation Check
        if(result.hasErrors()) {

            model.addAttribute("brands", brandRepo.findAll());

            model.addAttribute("categories", categoryRepo.findAll());

            return "addmobile";
        }

        repo.save(mobile);

        return "redirect:/";
    }

    // DELETE MOBILE
    @GetMapping("/delete/{id}")
    public String deleteMobile(@PathVariable int id,
                               HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        repo.deleteById(id);

        return "redirect:/";
    }

    // EDIT MOBILE PAGE
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id,
                           Model model,
                           HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        Mobile mobile = repo.findById(id).orElse(null);

        model.addAttribute("mobile", mobile);

        model.addAttribute("brands", brandRepo.findAll());

        model.addAttribute("categories", categoryRepo.findAll());

        return "editmobile";
    }

    // UPDATE MOBILE
    @PostMapping("/update")
    public String updateMobile(
            @Valid @ModelAttribute("mobile") Mobile mobile,
            BindingResult result,
            Model model,
            HttpSession session) {

        // Session Check
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // Validation Check
        if(result.hasErrors()) {

            model.addAttribute("brands", brandRepo.findAll());

            model.addAttribute("categories", categoryRepo.findAll());

            return "editmobile";
        }

        repo.save(mobile);

        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchMobile(@RequestParam("keyword") String keyword,
                               @RequestParam("type") String type,
                               Model model,
                               HttpSession session) {

        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Mobile> list = null;

        if(type.equals("model")) {

            list = repo.findByModelContainingIgnoreCase(keyword);

        } else if(type.equals("brand")) {

            list = repo.findByBrand_BrandNameContainingIgnoreCase(keyword);

        } else if(type.equals("category")) {

            list = repo.findByCategory_CategoryNameContainingIgnoreCase(keyword);

        }

        model.addAttribute("mobiles", list);

        return "index";
    }
}