package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @GetMapping(value = "/home")
    public String getHomePage(Model model) {
        return "home";
    }
}
