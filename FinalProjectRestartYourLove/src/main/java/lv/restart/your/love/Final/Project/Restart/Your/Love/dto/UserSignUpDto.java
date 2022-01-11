package lv.restart.your.love.Final.Project.Restart.Your.Love.dto;

import com.sun.istack.NotNull;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserSignUpDto {

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String matchingPassword;

    //constructors


    public UserSignUpDto() {
    }

    public UserSignUpDto(String username, String password, String matchingPassword) {
        this.username = username;
        this.password = password;
//        this.matchingPassword = matchingPassword;
    }


    //getters & setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
