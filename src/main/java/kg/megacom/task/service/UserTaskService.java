package kg.megacom.task.service;

import kg.megacom.task.models.UserTasks;

import java.util.List;

public interface UserTaskService {
    List<UserTasks> findUserTasks(Long userId, Long taskId);
}
