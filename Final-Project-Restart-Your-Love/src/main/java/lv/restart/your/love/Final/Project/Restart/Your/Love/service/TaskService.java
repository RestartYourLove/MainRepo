package lv.restart.your.love.Final.Project.Restart.Your.Love.service;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
