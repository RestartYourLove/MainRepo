package lv.restart.your.love.Final.Project.Restart.Your.Love.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthHelper {
    Authentication getAuthentication();
    String getName();
    UserDetails getUserDetails();

}
