package kg.megacom.task.service.impl;

import kg.megacom.task.models.Tasks;
import kg.megacom.task.repository.TaskRepo;
import kg.megacom.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Tasks> getList() {

        //получение всех задач
        Date currentDate = new Date();
        List<Tasks> tasksList = taskRepo.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(currentDate, new Date());
        return tasksList;
    }
}
