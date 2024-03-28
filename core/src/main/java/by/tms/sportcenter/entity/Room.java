package by.tms.sportcenter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "max_capacity")
    private int maxCapacity;
    @Column(name = "status")
    private String status;
    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;
}