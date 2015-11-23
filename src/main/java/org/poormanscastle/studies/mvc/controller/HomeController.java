package org.poormanscastle.studies.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georg on 23.11.15.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Hello, World!");
        model.addAttribute("tagline", "Nice to see you, to see you is nice!");

        return "welcome";
    }

}
