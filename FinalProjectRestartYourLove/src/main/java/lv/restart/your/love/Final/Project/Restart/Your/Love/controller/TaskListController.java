package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.auth.AuthHelper;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskListController {
    Logger logger = LoggerFactory.getLogger(TaskListController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthHelper authHelper;

    // Get all tasks
    @GetMapping("/tasklist")
    public String getAllTasks(Model model) {
        logger.info("Task list page open for user: " + authHelper.getUserDetails().getUsername() + ".");

        //Getting a list of all tasks from db
        List<Task> taskList = taskService.getAllTasks();

        //Getting the list of tasks with their status for logged in user form user model variable taskStatus
        User user = userRepository.findByUsername(authHelper.getName());
        List<TaskStatus> userTaskStatusList = user.getTaskStatus();

        //Comparing tasks and their statuses in the User (model) taskStatus list --
        //to the full taskList retrieved from db
        //If the task from db is found in the User taskStatus list, it's set as Completed in the Task model transiet variable "isCompleted"
        //and displayed as such
        for (TaskStatus taskStatus : userTaskStatusList) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskStatus.getTask().getId() == taskList.get(i).getId()) {
                    taskList.get(i).setCompleted(true);
                }
            }
        }

        //set taskList as a model named "taskTitle" attribute use in html
        model.addAttribute("taskTitle", taskList);
        return "tasklist";

    }


}
