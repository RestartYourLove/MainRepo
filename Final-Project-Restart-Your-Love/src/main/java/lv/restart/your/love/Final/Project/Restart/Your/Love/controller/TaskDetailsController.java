package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class TaskDetailsController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = {"/taskdetails"})
    public String getTaskDetails(Model model) {
        List<Task> taskDetails = taskService.getAllTasks();
        model.addAttribute("taskTitle", taskDetails);
        return "taskdetails";
    }

//    // Get the task details by ID
//    @GetMapping("/taskdetails/{id}")
//    public Task getTaskById(@PathVariable(value = "id") int id) {
//        return taskService.findById(id);
//    }
//
//
//    // Update task status (done / not done)
//    @PutMapping("/taskdetails/{id}")
//    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable int id) {
//
//        Optional<Task> myTask = Optional.ofNullable(taskService.findById(id));
//
//        if (!myTask.isPresent())
//            return ResponseEntity.notFound().build();
//
//        task.setId((long) id);
//
//        taskService.save(task);
//
//        return ResponseEntity.noContent().build();
//    }
}
