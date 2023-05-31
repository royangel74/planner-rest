package com.iagica.training.plannerrest.domain.model.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_role", schema = "helper")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uidrole",nullable = false)
    private Integer idRuolo;

    @Column(name="role",nullable = false,unique = true)
    private String ruolo;

    @Override
    public String toString(){
        return String.format("idRuolo:%s,role:%s",idRuolo,ruolo);
    }

}
