package kg.megacom.task.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int period;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date endDate;
}

