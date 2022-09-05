package kg.megacom.task.controllers;

import kg.megacom.task.models.Tasks;
import kg.megacom.task.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Api/v1/tasks")
public class UserController {
    private final TaskService taskService;

    public UserController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/list")
    List<Tasks> getList(@RequestParam Long userId){
        return taskService.getList();
    }

}
