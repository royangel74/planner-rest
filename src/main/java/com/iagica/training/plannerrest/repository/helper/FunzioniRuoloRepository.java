package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.FunzioniRuolo;
import com.iagica.training.plannerrest.domain.model.helper.FunzioniRuoloPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunzioniRuoloRepository extends JpaRepository<FunzioniRuolo, FunzioniRuoloPK> {
}
