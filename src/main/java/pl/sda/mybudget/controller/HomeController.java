package pl.sda.mybudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // home page
    // / and /home
    @GetMapping({"/home", "/"})
    String homePage() {
        return "home";
    }
}
