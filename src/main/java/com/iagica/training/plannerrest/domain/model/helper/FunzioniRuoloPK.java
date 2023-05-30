package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class FunzioniRuoloPK implements Serializable {

    private int idRuolo;

    private int idFunzione;

    public FunzioniRuoloPK(int idRuolo, int idFunction) {
        this.idRuolo = idRuolo;
        this.idFunzione = idFunction;
    }
}
