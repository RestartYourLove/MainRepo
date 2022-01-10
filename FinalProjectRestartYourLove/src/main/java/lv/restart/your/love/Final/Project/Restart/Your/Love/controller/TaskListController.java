package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.auth.AuthHelper;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.TaskStatusRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskListController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    // Get all tasks
    @GetMapping("/tasklist")
    public String getAllTasks(Model model) {
        List<Task> taskList = taskService.getAllTasks();

        User user = userRepository.findByUsername("liza2");
        List<TaskStatus> taskStatusList = user.getTaskStatus();

        List<TaskStatus> newStatusList = new ArrayList<>();

        for (TaskStatus taskStatus : taskStatusList) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskStatus.getTask().getId() == taskList.get(i).getId()) {
                    taskList.get(i).setStatus(true);
                }
            }
        }

        //list<Task> of tasks completed
        //get those and update taskList to mark completed tasks as completed

        model.addAttribute("taskTitle", taskList);
        model.addAttribute("newStatusList", newStatusList);
        return "tasklist";

    }

//    Method to get current user's information? using the authhelper interface

//    @Autowired
//    private AuthHelper authHelper;
//
//    @GetMapping(value = "/username")
//    public String currentUserName() {
//        return authHelper.getName(); //how to get user id from this?
//    }


}
