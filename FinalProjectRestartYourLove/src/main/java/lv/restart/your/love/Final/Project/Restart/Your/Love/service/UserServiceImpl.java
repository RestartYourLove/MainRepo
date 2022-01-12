package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.error.UserAlreadyExistException;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    //inject user repository interface
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //method that saves the registered user to database through the dto class
//    @Override
//    public User save(UserSignUpDto signUpDto) {
//        User user = new User(signUpDto.getUsername(), passwordEncoder.encode(signUpDto.getPassword()));
//
//        return userRepository.save(user);
//    }

//    @Override
//    public User registerNewUserAccount(UserSignUpDto signUpDto) throws UserAlreadyExistException {
//        return null;
//    }

    //METHOD THAT PERFORMS THE LOGIN BY FINDING THE USERNAME IN DATABASE
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);
       if (user == null) {
           throw new UsernameNotFoundException("Invalid username or password");
       }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public User save(UserSignUpDto signUpDto) {
        return null;
    }

    @Override
    public User registerNewUserAccount(UserSignUpDto signUpDto) throws UserAlreadyExistException {
        if (usernameExist(signUpDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + signUpDto.getUsername());
        }

        User user = new User(signUpDto.getUsername(), passwordEncoder.encode(signUpDto.getPassword()));
        return userRepository.save(user);

    }



    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
