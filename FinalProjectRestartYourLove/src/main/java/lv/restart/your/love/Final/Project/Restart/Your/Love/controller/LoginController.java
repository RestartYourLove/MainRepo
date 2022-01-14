package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    //login method that redirects user to tasklist page if they are already logged in
    @GetMapping("/login")
    public String login(Model model) {

        logger.debug("User login into existing profile.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            logger.error("Authentication not successful.");
            return "login";
        }
        logger.info("User - " + authentication.getName() + " - logged in.");
        return "redirect:/tasklist";
    }
}
