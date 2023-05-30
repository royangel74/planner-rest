package com.iagica.training.plannerrest.domain.dto.request;

import com.iagica.training.plannerrest.domain.model.helper.Operation;
import com.iagica.training.plannerrest.domain.model.helper.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
