package com.iagica.training.plannerrest.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
