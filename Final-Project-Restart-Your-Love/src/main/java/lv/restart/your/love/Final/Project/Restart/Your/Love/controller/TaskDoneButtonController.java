package lv.restart.your.love.Final.Project.Restart.Your.Love.controller;

import lv.restart.your.love.Final.Project.Restart.Your.Love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskDoneButtonController {

    @Autowired
    private TaskService taskService;

    // SUBMIT TASK - button
    String statusValue = "";

    @GetMapping
    public String statusCheck(Model model){
        String statusValue = taskService.findById(1).getStatus();
        model.addAttribute("statusValue", statusValue);
        return "taskdetails";
    }

    @PostMapping
    public String done(Model model,@RequestParam String action) {

        System.out.println(action);

        if (action.equals("done")) {
            statusValue = "Task is done";
            model.addAttribute("statusValue", statusValue);
        }

        return "taskdetails";
    }

}
