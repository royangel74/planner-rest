package com.iagica.training.plannerrest.domain.dto.request;

import com.iagica.training.plannerrest.domain.model.helper.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    String password;

}
