package by.tms.sportcenter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "sportcenter", name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "service_name")
    private String serviceName;
    private BigDecimal cost;
}