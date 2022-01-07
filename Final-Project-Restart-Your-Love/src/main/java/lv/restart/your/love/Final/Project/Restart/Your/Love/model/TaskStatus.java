package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task_status")
public class TaskStatus {

    @EmbeddedId
    private TaskStatusKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    private String status;


    //constructors
    public TaskStatus() {
    }

    public TaskStatus(User user, Task task, String status) {
        this.user = user;
        this.task = task;
        this.status = status;
    }

    public TaskStatus(TaskStatusKey id, User user, Task task, String status) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.status = status;
    }

    //getters and setters
    public TaskStatusKey getId() {
        return id;
    }

    public void setId(TaskStatusKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskStatus that = (TaskStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(task, that.task) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, task, status);
    }
}
