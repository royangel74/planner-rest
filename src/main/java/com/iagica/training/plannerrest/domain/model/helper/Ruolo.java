package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_role", schema = "helper")
public class Ruolo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uidrole", nullable = false)
    private Integer idRuolo;

    @Column(name = "role")
    private String ruolo;
}
