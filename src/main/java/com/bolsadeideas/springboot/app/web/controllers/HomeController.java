package com.bolsadeideas.springboot.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Redirect to another Route (res.redirect in Express)

    /**
     * Redirect -> Refresh Tab
     * Forward -> No Refresh, data in Tab is not reset | Project's own routes.
     * */

    @GetMapping({"/", ""})
    public String home() {
        return "forward:/app/index";
    }

    @GetMapping("/google")
    public String google() {
        return "redirect:https://www.google.com";
    }

}
