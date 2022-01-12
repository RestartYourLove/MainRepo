package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.auth.AuthHelper;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.TaskStatusRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class TaskDoneButtonController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthHelper authHelper;


    //Mark status as done and add it to db join table
    @GetMapping(value = {"/done/{id}"})
    public String markDone(@PathVariable(value = "id") long id, Model model) {

        //Get the currently logged in user
        User currentUser = userRepository.findByUsername(authHelper.getName());

        //get currently opened task by id from the service
        Task myTask = taskService.findById(id);

        //save the TaskStatus and update the task_status table in db
        TaskStatus ts1 = new TaskStatus(currentUser, myTask ,true);
        taskStatusRepository.save(ts1);

        //set task as a model attribute to pre-populate the form
        model.addAttribute("myTask", myTask);


        return "redirect:/taskdetails/{id}";
    }


    //Undo mark task status done and remove it from db join table
    @GetMapping(value = {"/notdone/{id}"})
    public String markNotDone(@PathVariable(value = "id") long id, Model model) {

        //Get the currently logged in user
        User currentUser = userRepository.findByUsername(authHelper.getName());

        //get currently opened task by id from the service
        Task myTask = taskService.findById(id);

        //save the TaskStatus and update the task_status table in db
        TaskStatus ts1 = new TaskStatus(currentUser, myTask ,true);
        taskStatusRepository.delete(ts1);

        //set task as a model attribute to pre-populate the form
        model.addAttribute("myTask", myTask);


        return "redirect:/taskdetails/{id}";
    }
}
