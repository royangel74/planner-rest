package com.iagica.training.plannerrest.domain.model.planner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_agenda", schema = "planner", catalog = "dbplanner",
       uniqueConstraints = {@UniqueConstraint( columnNames = {"masterdate", "eventstart", "eventexpire", "uidenvent"})})
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uidagenda", nullable = false)
    private Integer uidagenda;
    @Basic
    @Column(name = "masterdate", nullable = false)
    private LocalDate masterdate;
    @Basic
    @Column(name = "eventstart", nullable = false)
    private LocalTime eventstart;
    @Basic
    @Column(name = "eventexpire", nullable = false)
    private LocalTime eventexpire;
    @Basic
    @Column(name = "eventpublic", nullable = false, length = -1)
    private String eventpublic;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uidenvent")
    public Event event;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda that = (Agenda) o;
        return Objects.equals(uidagenda, that.uidagenda) && Objects.equals(masterdate, that.masterdate) && Objects.equals(eventstart, that.eventstart) && Objects.equals(eventexpire, that.eventexpire) && Objects.equals(eventpublic, that.eventpublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidagenda, masterdate, eventstart, eventexpire, eventpublic);
    }
}
