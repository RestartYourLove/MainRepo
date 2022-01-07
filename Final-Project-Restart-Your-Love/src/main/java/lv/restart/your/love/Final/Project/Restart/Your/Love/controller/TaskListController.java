package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskListController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping("/tasklist")
    public String getAllTasks(Model model) {
        List<Task> taskList = taskService.getAllTasks();
        model.addAttribute("taskTitle", taskList);
        return "tasklist";

    }


}
