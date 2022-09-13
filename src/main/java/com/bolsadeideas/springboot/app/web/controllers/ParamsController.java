package com.bolsadeideas.springboot.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping({"/", ""})
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    // @RequestParam -> Params ?query=algo
    public String param(@RequestParam(name = "text", required = false, defaultValue = "No value.") String text, Model model) {
        model.addAttribute("result", "Param received: ".concat(text));
        return "params/view";
    }

    // Different Params
    @GetMapping("/mix-params")
    public String param(@RequestParam String greeting, @RequestParam Integer number, Model model) {
        model.addAttribute("result", "String param: '" + greeting + ".' " + " | Number Param: " + number);
        return "params/view";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "String param: '" + greeting + ".' " + " | Number Param: " + number);
        return "params/view";
    }
}
