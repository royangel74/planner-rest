package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tab_function_role",schema = "helper")
public class FunctionRole {

    @EmbeddedId
     private FunctionRolePK functionRolePK;
}
