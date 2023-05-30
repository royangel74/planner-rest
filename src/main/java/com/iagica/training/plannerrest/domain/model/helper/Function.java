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
@Table(name = "tab_function",schema = "helper")
public class Function {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="uidfunction",nullable = false)
    private Integer idFunction;

    @Column(name = "typefunction",nullable = false)
    private String typeFunction;

    @Column(name = "accesfunction",nullable =false)
    private String accesFunction;



}
