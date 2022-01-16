package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;
import lv.restart.your.love.Final.Project.Restart.Your.Love.error.UserAlreadyExistException;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {
    User user = new User();
    user.setUsername("userTest");
    user.setPassword("0000");

    when(userRepository.findByUsername(anyString())).thenReturn(user);

    UserDetails userdetails = userService.loadUserByUsername("user1");

    assertNotNull(userdetails);
    assertEquals("userTest", userdetails.getUsername());
    }

    @Test
    void loadUserByUsernameUsernameNotFoundExceptionTest() {
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,
                ()->{
                    userService.loadUserByUsername("user1");
                }
                );
    }
    
    @Test
    void saveTest() {
        UserSignUpDto signUpDto = new UserSignUpDto();
        signUpDto.setUsername("userTest");
        signUpDto.setPassword("qwerty");
        User user = new User(signUpDto.getUsername(), signUpDto.getPassword());
        userRepository.save(user);
        assertNotNull(user);
        assertEquals("userTest", user.getUsername());
    }


//NOT FINISHED
    @Test
    void registerNewUserAccountTest() {
        UserSignUpDto signUpDto = new UserSignUpDto();
        signUpDto.setUsername("userTest");
        signUpDto.setPassword("qwerty");
        User notSavedUser = new User(signUpDto.getUsername(), signUpDto.getPassword());


        UserSignUpDto signUpDto2 = new UserSignUpDto();
        signUpDto2.setUsername("userTest2");
        signUpDto2.setPassword("qwerty2");
        User savedUser2 = new User(signUpDto2.getUsername(), signUpDto2.getPassword());
        userRepository.save(savedUser2);

        when(userRepository.findByUsername(savedUser2.getUsername()).equals(notSavedUser.getUsername())).thenReturn(null);
//        userRepository.save(notSavedUser);

//        assertNotNull(userdetails);


    }

    @Test
    void registerNewUserAccountUserAlreadyExistExceptionTest() {
    }
}