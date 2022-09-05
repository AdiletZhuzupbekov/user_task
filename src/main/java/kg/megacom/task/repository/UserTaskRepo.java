package kg.megacom.task.repository;

import kg.megacom.task.models.Tasks;
import kg.megacom.task.models.User;
import kg.megacom.task.models.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepo extends JpaRepository<UserTasks, Long> {
    UserTasks findTopByUserAndTasks(User user, Tasks tasks);

    UserTasks findByTasks(Tasks tasks);

}
