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
public class Funzione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuidfunction", nullable = false)
    private int idOperazione;

    @Column(name = "accessfunction", nullable = false)
    private Operation accessoOperazione;

    @Column(name = "typefunction", nullable = false)
    private String tipoOperazione;


}
