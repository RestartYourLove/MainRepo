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
    //this list includes the tasks and their statuses. Your task and status fields are included in private List<TaskStatus> taskStatus.

    //doesn't get stored in db
    @Transient
    private boolean isCompleted;

    //constructors
    public Task() {
    }

    public Task(Long id, String title, String description, List<TaskStatus> taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
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


    //printing status on screen
    //if the task by specified id is in the taskStatus list (where finished tasks are added by user) --
    //then task status is printed as Completed. Otherwise - not completed;
    public String printStatus() {
        String statusString = "";
        if (this.isCompleted) {
            statusString = "Completed";
        } else {
            statusString = "Not completed";
        }
        return statusString;
    }


        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(taskStatus, task.taskStatus);
        }

        @Override
        public int hashCode () {
            return Objects.hash(id, title, description, taskStatus);
        }
    }
