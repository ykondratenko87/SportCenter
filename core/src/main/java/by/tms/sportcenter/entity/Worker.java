package by.tms.sportcenter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "sportcenter", name = "worker")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_worker_id")
public class Worker extends User {
    @Column(name = "first_work_day")
    private LocalDate firstWorkDay;
    private LocalDate dismissal;
    private String position;
    private BigDecimal salary;
}