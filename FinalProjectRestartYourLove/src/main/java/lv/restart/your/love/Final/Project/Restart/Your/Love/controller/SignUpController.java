package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;


    //method that returns an empty user object used while registering
    @ModelAttribute("user")
    public UserSignUpDto userSignUpDto() {
        return new UserSignUpDto();
    }

    @GetMapping("/signup")
    public String showSignUpForm(WebRequest request, Model model) {
        UserSignUpDto signUpDto = new UserSignUpDto();
        model.addAttribute("user", signUpDto);
        return "signup";
    }

//    by Liza
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user")UserSignUpDto signUpDto) {
//        userService.save(signUpDto);
//        return "redirect:/signup?success";
//    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Validated UserSignUpDto signUpDto,
                                      HttpServletRequest request) {
        userService.save(signUpDto);

//        try {
//            User registered = userService.registerNewUserAccount(signUpDto);
//        } catch (UserAlreadyExistException uaeEx) {
//            mav.addObject("message", "An account for that username/email already exists.");
//            return mav;
//        }
        return "redirect:/signup?success";
//        return new ModelAndView("successRegister", "user", signUpDto);
    }


}
