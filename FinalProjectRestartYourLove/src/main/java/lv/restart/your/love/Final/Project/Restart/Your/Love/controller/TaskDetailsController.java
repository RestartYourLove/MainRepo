package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

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


@Controller
public class TaskDetailsController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    // Get the task details by ID
    @GetMapping(value = {"/taskdetails/{id}"})
    public String getTaskById(@PathVariable(value = "id") long id, Model model) {

        //Getting the list of tasks with their status for specified user
        User currentUser = userRepository.findByUsername("liza2");
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



//    // Update task status (done / not done)
//    @PutMapping("/taskdetails/{id}")
//    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {
//
//        Optional<Task> myTask = Optional.ofNullable(taskService.findById(id));
//
//        if (!myTask.isPresent())
//            return ResponseEntity.notFound().build();
//
//        task.setStatus();
//
//        taskService.save(task);
//
//        return ResponseEntity.noContent().build();
//    }
}
