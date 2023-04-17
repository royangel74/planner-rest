package com.iagica.training.plannerrest.domain.model.planner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_event", schema = "planner", catalog = "dbplanner")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uidenvent", nullable = false)
    private Integer uidenvent;
    @Basic
    @Column(name = "uideventtype", nullable = false)
    private Integer uideventtype;
    @Basic
    @Column(name = "eventdescription", nullable = true, length = 200)
    private String eventdescription;
    @Basic
    @Column(name = "eventcreation", nullable = false)
    private Timestamp eventcreation;
    @Basic
    @Column(name = "eventupdate", nullable = true)
    private Timestamp eventupdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event that = (Event) o;
        return Objects.equals(uidenvent, that.uidenvent) && Objects.equals(uideventtype, that.uideventtype) && Objects.equals(eventdescription, that.eventdescription) && Objects.equals(eventcreation, that.eventcreation) && Objects.equals(eventupdate, that.eventupdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidenvent, uideventtype, eventdescription, eventcreation, eventupdate);
    }
}
