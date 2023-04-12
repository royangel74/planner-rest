package com.iagica.training.plannerrest.domain.model.planner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_agenda", schema = "planner",
       uniqueConstraints = {@UniqueConstraint( columnNames = {"masterdate", "starteventtime", "endeventtime", "event_id"})})
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate masterDate;

    @Column(nullable = false)
    private LocalTime startEventTime;

    @Column(nullable = false)
    private LocalTime endEventTime;

    @Column(nullable = false)
    private Boolean eventPublic;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    public Event event;
}
