package lv.restart.your.love.Final.Project.Restart.Your.Love.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "task_type")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "task")
    private List<TaskStatus> taskStatus = new ArrayList<>();
    //this Set includes the tasks and their statuses. Your task and status fields are included in private Set<TaskStatus> taskStatus.

    @Transient
    private boolean status;

    //constructors
    public Task() {
    }

    public Task(Long id, String title, String description, List<TaskStatus> taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    //custom show status method
//    public String getStatusString() {
//        if (taskStatus.equals(0)) {
//            return "Not done";
//        } else {
//            return "Done";
//        }
//    }


    //custom boolean get status method to change card color in html based on task status
    public boolean isDone() {
        if (taskStatus.equals(0)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(taskStatus, task.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, taskStatus);
    }
}
