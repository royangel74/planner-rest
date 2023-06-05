package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FunctionRolePK {
    @ManyToOne
    @JoinColumn(name = "uidrole")
    private Role uidrole;
    @ManyToOne
    @JoinColumn(name = "uidfunction")
    private Function uidfunction;
}
