package com.iagica.training.plannerrest.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private Integer idFunction;
    private String typeFunction;
    private String AccessFunction;
}
