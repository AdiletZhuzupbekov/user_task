package kg.megacom.task.repository;

import kg.megacom.task.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date currentDate, Date date);
}

