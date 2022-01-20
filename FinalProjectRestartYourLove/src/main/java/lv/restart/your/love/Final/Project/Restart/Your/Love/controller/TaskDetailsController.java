package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.auth.AuthHelper;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.TaskStatus;
import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.UserRepository;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 *  TaskDetailsController class is used to redirect user to the taskdetails.html page taking into account users ID.
 */
@Controller
public class TaskDetailsController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthHelper authHelper;

    // Get the task details by ID
    @GetMapping(value = {"/taskdetails/{id}"})
    public String getTaskById(@PathVariable(value = "id") long id, Model model) {

        //Getting the list of tasks with their status for specified user
        User currentUser = userRepository.findByUsername(authHelper.getName());
        List<TaskStatus> userTaskStatusList = currentUser.getTaskStatus();

        //get task from the service
        Task myTask = taskService.findById(id);

        //seeing if this specific task is also added to current users completed task list (userTaskStatusList)
        //if it is, it's marked as true (completed) in Task model's transient variable 'isCompleted'
        //and displayed as such using the printStatus() method
        for (TaskStatus taskStatus : userTaskStatusList) {
                if (taskStatus.getTask().getId() == myTask.getId()) {
                    myTask.setCompleted(true);
                }
            }

        //set task as a model attribute to pre-populate the form
        model.addAttribute("myTask", myTask);

        return "taskdetails";
    }

}
