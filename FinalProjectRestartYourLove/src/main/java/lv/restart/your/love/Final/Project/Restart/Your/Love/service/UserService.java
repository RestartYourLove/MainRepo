package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserSignUpDto signUpDto);

    //some new stuff - new use username data check
    @Override
    public User registerNewUserAccount(UserSignUpDto signUpDto) throws UserAlreadyExistException {
        if (usernameExist(signUpDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + signUpDto.getUsername());
        }

        // the rest of the registration operation --?
    }
    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
