package com.iagica.training.plannerrest.domain.model.planner;

import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.domain.model.helper.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_event", schema = "planner")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uidenvent",nullable = false)
    private Integer uidEnvent;

    @Column(name="eventdescription",nullable = true,length = 255)
    private String description;
    @CreatedDate
    @Column(name="eventcreation",nullable = false)
    private LocalDateTime eventcreation;
    @LastModifiedDate
    @Column(name="eventupdate",nullable = true)
    private LocalDateTime modifiedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uideventtype")
    public EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="uiduser")
    public User user;

}
