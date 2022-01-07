package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
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

    // Get the task details by ID
    @GetMapping(value = {"/taskdetails/{id}"})
    public String getTaskById(@PathVariable(value = "id") long id, Model model) {

        //get task from the service
        Task myTask = taskService.findById(id);

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
