package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.error.UserAlreadyExistException;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserService userService;


    //method that returns an empty user object used while registering
    @ModelAttribute("user")
    public UserSignUpDto userSignUpDto() {
        return new UserSignUpDto();
    }

    @GetMapping
    public String showSignUpForm(WebRequest request, Model model) {
        UserSignUpDto signUpDto = new UserSignUpDto();
        model.addAttribute("user", signUpDto);
        return "signup";
    }


    @PostMapping
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserSignUpDto signUpDto, HttpServletRequest request, ModelAndView mav,
                                            Errors errors){
        logger.debug("Registering User account.");
        try {
            User registered = userService.registerNewUserAccount(signUpDto);
            logger.info("User registered with username: " + signUpDto.getUsername());
        } catch (UserAlreadyExistException uaeEx) {
            logger.error("Username - " + signUpDto.getUsername() + " - already exists.");
            mav.addObject("message", "An account for that username already exists.");
            mav.setViewName("errorSignup");
            return mav;
        }


        return new ModelAndView("successSignup", "user", signUpDto);

    }

}
