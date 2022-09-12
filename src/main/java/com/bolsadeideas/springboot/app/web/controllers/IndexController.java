package com.bolsadeideas.springboot.app.web.controllers;

import com.bolsadeideas.springboot.app.web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
// First Level Route
@RequestMapping("/app")
public class IndexController {

    // Second Level Route, Ej -> /app/...routes...
    @GetMapping({ "/", "", "/index"})
    public String index(Model model) {
        // Pass Data to View -> Model (Interface)
        model.addAttribute("title", "Spring Web App");
        // Returns Views Name -> resources/templates/index.html
        return "index";
    }

    @GetMapping({"/profile"})
    public String profile(Model model) {
        User user = new User();
        // Set User Info
        user.setName("Chris");
        user.setLastName("Martinez Lara");
        // Show User info with Model
        user.setEmail("chris@gmail.com");
        model.addAttribute("user", user);
        return "profile";
    }

    // List Users
    @GetMapping({"/list"})
    public String list(Model model) {
        return "list";
    }
    
    // Model Attribute to pass data to a view Global -> "users" model name
    @ModelAttribute("users")
    public List<User> populateUsers() {
    	 // Add to a List separate by commas
        List<User> users = Arrays.asList(
                new User("Jose", "Martinez", "jose.luis@gmail.com"),
                new User("Carmen S.", "Lara Figueroa", "suyapa@gmail.com"),
                new User("Maria", "Lara", "maria@gmail.com")
        );
        return users;
    }

}
