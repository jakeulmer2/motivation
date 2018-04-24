package jakeulmer.motivation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Motivation");

        return "home/index";
    }

}
