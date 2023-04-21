package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_event_type", schema = "helper")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uideventtype")
    private Integer uidEventType;
    @Basic
    @Column(name="eventname",nullable = false,length = 255)
    private String eventName;
}
