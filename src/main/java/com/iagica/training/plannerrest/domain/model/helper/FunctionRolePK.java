package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionRolePK {

    @Column(name = "uidrole")
    private Integer idRuolo;


    @Column(name="uidfunction")
    private Integer idFunction;
}
