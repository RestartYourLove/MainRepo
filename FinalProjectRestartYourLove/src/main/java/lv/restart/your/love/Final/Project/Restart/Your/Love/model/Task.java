package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "task")
    private Set<TaskStatus> status = new HashSet<>();


    //constructors
    public Task() {
    }

    public Task(Long id, String title, String description, Set<TaskStatus> status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TaskStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<TaskStatus> status) {
        this.status = status;
    }

    //custom boolean get status method to change card color in html based on task status
    public boolean isDone() {
        if (status.contains("Done")) {
            return true;
        } else {
            return false;
        }
    }

    //temporary!! custom method to display that the task is Not done if it's not stated otherwise
    public String taskStatus() {
        if (status.isEmpty()) {
            return "Not Done";
        } else {
            return "Done";
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status);
    }
}
