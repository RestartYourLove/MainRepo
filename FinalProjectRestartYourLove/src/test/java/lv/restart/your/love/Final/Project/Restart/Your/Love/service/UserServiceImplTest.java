package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
}