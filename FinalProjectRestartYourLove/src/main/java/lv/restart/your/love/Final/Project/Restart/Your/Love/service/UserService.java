package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.error.UserAlreadyExistException;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    //method that saves the registered user to database through the dto class
    User save(UserSignUpDto signUpDto);


    User registerNewUserAccount(UserSignUpDto signUpDto) throws UserAlreadyExistException;
}
