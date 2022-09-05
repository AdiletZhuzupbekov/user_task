package kg.megacom.task.service.impl;

import kg.megacom.task.models.Tasks;
import kg.megacom.task.models.User;
import kg.megacom.task.models.UserTasks;
import kg.megacom.task.repository.TaskRepo;
import kg.megacom.task.repository.UserRepo;
import kg.megacom.task.repository.UserTaskRepo;
import kg.megacom.task.service.TaskService;
import kg.megacom.task.service.UserTaskService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserTaskServiceImpl implements UserTaskService {
    private final UserRepo userRepo;
    private final TaskRepo taskRepo;
    private final UserTaskRepo userTaskRepo;
    private final TaskService taskService;

    public UserTaskServiceImpl(UserRepo userRepo, TaskRepo taskRepo, UserTaskRepo userTaskRepo, TaskService taskService) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
        this.userTaskRepo = userTaskRepo;

        this.taskService = taskService;
    }


    @Override
    public List<UserTasks> findUserTasks(Long userId, Long taskId) {
        Tasks task = taskRepo.findById(taskId).orElseThrow();
        //получение всезх задач
        List<Tasks> tasksList = taskService.getList();
        User user = userRepo.findById(userId).orElseThrow();

        //введение полученных задач в юзер таск

        for (int i = 0; i < tasksList.size(); i++) {

            UserTasks userTasks = userTaskRepo.findByTasks(tasksList.get(i));
            if (userTasks == null) {
                UserTasks userTask = new UserTasks();
                userTask.setUser(user);
                userTask.setTasks(tasksList.get(i));
                userTask.setAddDate(new Date());
                userTaskRepo.save(userTask);
            }
        }

        //последняя запись
        UserTasks userTasks = userTaskRepo.findTopByUserAndTasks(user, task);
        //Если запись есть, проверить что current_date > add_date + period
        Date dp = userTasks.getAddDate();
        Calendar c = Calendar.getInstance();
        c.setTime(dp);
        c.add(Calendar.MINUTE, task.getPeriod());
        dp = c.getTime();
        Date current = new Date();
        if (!current.after(dp)){
            userTaskRepo.delete(userTasks);
        }


        return userTaskRepo.findAll();
    }
}
