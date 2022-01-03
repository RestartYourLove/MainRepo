package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.Task;
import lv.restart.your.love.Final.Project.Restart.Your.Love.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

//    @GetMapping("/taskController")
//    public String taskController() {
//        return "taskController";
//    }

@Autowired
private TaskRepository repo;

    // Home Page
    @GetMapping("/")
    public String welcome(Model model)
    {
        List<Task> taskList = repo.findAll();
        model.addAttribute("taskTitle", taskList);
//        model.addAttribute("name", "BlaBla");
        return "/mainactivity";
    }

    // Get All
    @GetMapping("/mainactivity")
    public List<Task> getAllNotes()
    {
        return repo.findAll();
    }

    // Get the task details by ID
    @GetMapping("/mainactivity/{id}")
    public Task getTaskById(
            @PathVariable(value = "id") int id)
    {
        return repo.findById(id);
    }

    @PostMapping("/mainactivity")
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(
            @RequestBody Task task)
    {
        return repo.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(
            @PathVariable(value = "id") int id)
    {
        repo.deleteById(id);
    }

    @PutMapping("/mainactivity/{id}")
    public ResponseEntity<Object> updateTask(
            @RequestBody Task task,
            @PathVariable int id)
    {

        Optional<Task> taskRepo
                = Optional.ofNullable(
                repo.findById(id));

        if (!taskRepo.isPresent())
            return ResponseEntity
                    .notFound()
                    .build();

        task.setId((long) id);

        repo.save(task);

        return ResponseEntity
                .noContent()
                .build();
    }
}
