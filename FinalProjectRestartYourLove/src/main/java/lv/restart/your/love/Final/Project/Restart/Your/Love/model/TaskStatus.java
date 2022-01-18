package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "task_status")
public class TaskStatus implements Serializable {

    @EmbeddedId
    private TaskStatusKey id;

    @ManyToOne
    @MapsId("userId") //This is the name of attr in TaskStatusKey class
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "status_done", columnDefinition = "boolean default true")
    private boolean statusDone = true;


    //constructors
    public TaskStatus() {
    }

    public TaskStatus(User user, Task task, boolean statusDone) {
        this.id = new TaskStatusKey(user.getId(), task.getId());
        this.user = user;
        this.task = task;
        this.statusDone = statusDone;
    }

    public TaskStatus(TaskStatusKey id, User user, Task task, boolean statusDone) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.statusDone = statusDone;
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

    public boolean getStatusDone() {
        return statusDone;
    }

    public void setStatusDone(boolean statusDone) {
        this.statusDone = statusDone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskStatus that = (TaskStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(task, that.task) && Objects.equals(statusDone, that.statusDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, task, statusDone);
    }
}
