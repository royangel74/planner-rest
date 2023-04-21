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
       uniqueConstraints = {@UniqueConstraint( columnNames = {"masterdate", "eventstart", "eventexpire", "uidenvent"})})
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uidagenda",nullable = false)
    private Integer uidAgenda;

    @Column(name="masterdate",nullable = false)
    private LocalDate masterDate;

    @Column(name="eventstart",nullable = false)
    private LocalTime eventStart;

    @Column(name="eventexpire",nullable = false)
    private LocalTime eventExpired;

    @Column(name="eventpublic",nullable = false,length = 255)
    private String eventPublic;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uidenvent")
    public Event event;
}
