package lv.restart.your.love.Final.Project.Restart.Your.Love.dto;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserSignUpDto {

    private String username;
    private String password;


    public UserSignUpDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserSignUpDto() {
    }

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

}
