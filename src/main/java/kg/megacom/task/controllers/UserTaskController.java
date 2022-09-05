package kg.megacom.task.controllers;

import kg.megacom.task.models.UserTasks;
import kg.megacom.task.service.UserTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Api/v1/tasks")
public class UserTaskController {
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }


    @GetMapping("/check_user_tasks")
    List<UserTasks> findUserTasks(@RequestParam Long userId, @RequestParam Long taskId){
        return userTaskService.findUserTasks(userId, taskId);
    }
}
