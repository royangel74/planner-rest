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
@Table(name = "tab_function", schema = "helper")
public class FunzioniRuolo {

    @EmbeddedId
    private FunzioniRuoloPK funzioniRuoloPK;
}




