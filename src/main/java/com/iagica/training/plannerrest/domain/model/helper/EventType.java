package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_eventtype", schema = "helper")
public class EventType {
    @Id
    @GeneratedValue
    private Integer id;
    private String eventName;
}
