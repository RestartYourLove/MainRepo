package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainActivityController {

    @GetMapping("/")
    public String mainActivity() {

        return "mainactivity";
    }
}
