package com.bolsadeideas.springboot.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({ "/", "/index"})
    public String index(Model model) {
        // Pass Data to View -> Model (Interface)
        model.addAttribute("title", "Spring Web App");
        // Returns Views Name -> resources/templates/index.html
        return "index";
    }

}
