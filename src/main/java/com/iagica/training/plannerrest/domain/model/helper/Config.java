package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tab_config",schema = "helper")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uidconfig",nullable = false)
    private Integer uidConfig;

    @Column(name="keyname",nullable = false)
    private String keyname;
    @Column(name ="keyvalue",nullable = false )
    private String keyvalue;
    @Column(name="explanation",nullable = false)
    private String explanation;
    @Column(name="expiration",nullable = false)
    private LocalDateTime expiration;
}
