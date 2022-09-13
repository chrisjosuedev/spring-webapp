package com.bolsadeideas.springboot.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablePathController {

    @GetMapping({"/", ""})
    public String index() {
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("result", "Param received from Route (@PathVariable): ".concat(text));
        return "variables/view";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
        model.addAttribute("result",
                "Param received from Route (@PathVariable) with multiple data types: "
                .concat("String: " + text)
                .concat(" | Int: " + number));
        return "variables/view";
    }

}
