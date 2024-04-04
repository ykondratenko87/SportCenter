package by.tms.sportcenter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "sportcenter", name = "customer")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_customer_id")
public class Customer extends User {
    @Column(name = "first_visit_date")
    private LocalDate firstVisitDate;
    @Column(name = "last_visit_date")
    private LocalDate lastVisitDate;
    @Column(name = "spent_amount")
    private BigDecimal spentAmount;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}