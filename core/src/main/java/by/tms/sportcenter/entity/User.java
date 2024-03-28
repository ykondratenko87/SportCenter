package by.tms.sportcenter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "sportcenter", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "last_visit_date")
    private LocalDate lastVisitDate;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column(name = "spent_amount")
    private BigDecimal spentAmount;
}