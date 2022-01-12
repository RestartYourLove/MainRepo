package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.auth.AuthHelper;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class TaskDoneButtonController {

//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private AuthHelper authHelper;
//
//
//    @PostMapping(value = {"/done/{id}"})
//    public String markDone(@PathVariable(value = "id") long id, Model model) {
//
//        //Getting the list of tasks with their status for specified user
//        User currentUser = userRepository.findByUsername(authHelper.getName());
//        List<TaskStatus> userTaskStatusList = currentUser.getTaskStatus();
//
//        //get task from the service
//        Task myTask = taskService.findById(id);
//
//        //seeing if this specific task is also added to current users completed task list (userTaskStatusList)
//        //if it's not, it's added..
//        for (TaskStatus taskStatus : userTaskStatusList) {
//            if (taskStatus.getTask().getId() != myTask.getId()) {
//                userTaskStatusList.add(taskStatus);
//                currentUser.addTaskStatus(taskStatus);
//            }
//        }
//
//        userRepository.save(currentUser);
//
//
//
//        //set task as a model attribute to pre-populate the form
//        model.addAttribute("myTask", myTask);
//
//        return "redirect:/taskdetails";
//    }

}
