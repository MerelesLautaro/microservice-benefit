package com.lautadev.microservice_benefit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;

    @ElementCollection(targetClass = DayWeek.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "benefit_days", joinColumns = @JoinColumn(name = "benefit_id"))
    @Column(name = "day_of_week")
    @Size(min = 1, message = "At least one day of the week must be selected")
    private List<DayWeek> day;
    @PositiveOrZero
    private Integer tickets;
}
