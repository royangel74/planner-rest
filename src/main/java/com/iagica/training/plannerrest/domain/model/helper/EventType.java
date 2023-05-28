package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_event_type", schema = "helper", catalog = "dbplanner")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uidenventtype", nullable = false)
    private Integer uidenventtype;

    @Basic
    @Column(name = "eventname", nullable = false, length = 256)
    private String eventname;

    @Basic
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventType that = (EventType) o;
        return uidenventtype == that.uidenventtype && duration == that.duration && Objects.equals(eventname, that.eventname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidenventtype, eventname, duration);
    }
}
