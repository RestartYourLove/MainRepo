package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;


@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //creating third connected table
    @JoinTable(
            name = "users_progress",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "finished_task_id", referencedColumnName = "id"))

    private Collection<Task> finishedTasks;
    //why like this? is there a better way?
    //how to add ONLY current users finished tasks to this table?


    public User() {
    }

    public User(String username, String password, Collection<Task> finishedTasks) {
        this.username = username;
        this.password = password;
        this.finishedTasks = finishedTasks;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Task> getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(Collection<Task> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }
}
