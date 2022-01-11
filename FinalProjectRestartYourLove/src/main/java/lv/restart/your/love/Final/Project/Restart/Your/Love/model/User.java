package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TaskStatus> taskStatus = new ArrayList<>();
    //this list includes the tasks and their statuses. Your task and status fields are included in private List<TaskStatus> taskStatus.

    //Constructors
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password, List<TaskStatus> taskStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.taskStatus = taskStatus;
    }



    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<TaskStatus> getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(List<TaskStatus> taskStatus) {
        this.taskStatus = taskStatus;
    }

    //Custom method

    //adding tasks to a user in db
    //try to test it
    public List<TaskStatus> addTaskStatus(TaskStatus taskStatus) {
        this.taskStatus.add(taskStatus);
        return this.taskStatus;
    }


    //Overriding spring security authorization by creating a mock (empty) authority
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(taskStatus, user.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, taskStatus);
    }
}
