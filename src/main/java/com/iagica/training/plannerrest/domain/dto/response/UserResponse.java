package com.iagica.training.plannerrest.domain.dto.response;

import com.iagica.training.plannerrest.domain.model.helper.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Integer uidUser;
    private String name;
    private String surname;
    private String username;
    private Role ruolo;
}
