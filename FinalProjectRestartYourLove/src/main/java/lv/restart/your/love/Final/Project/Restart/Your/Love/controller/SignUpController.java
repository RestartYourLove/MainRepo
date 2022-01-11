package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController extends WebMvcConfigurerAdapter {

    @Autowired
    private UserService userService;


    //method that returns an empty user object used while registering
    @ModelAttribute("user")
    public UserSignUpDto userSignUpDto() {

        return new UserSignUpDto();
    }

    @GetMapping
    public String showSignUpForm() {

        return "signup";
    }

//    by Liza
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user")UserSignUpDto signUpDto) {
//        userService.save(signUpDto);
//        return "redirect:/signup?success";
//    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user")UserSignUpDto userSignUpDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.save(userSignUpDto);
        return "redirect:/signup?success";
    }

}
