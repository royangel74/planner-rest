package com.iagica.training.plannerrest.domain.dto.response;

import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.domain.model.helper.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FunctionRoleResponse {

    private Role role;
    private Function function;

    private String access;
}
