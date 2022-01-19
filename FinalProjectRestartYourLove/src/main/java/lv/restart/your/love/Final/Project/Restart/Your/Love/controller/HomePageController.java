package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomePageController class is used to redirect user to the home.html page.
 */
@Controller
public class HomePageController {

    @GetMapping(value = {"/","/home"})
    public String getHomePage() {
        return "home";
    }
}
