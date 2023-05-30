package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Ruolo;

public interface RoleRepositoryCustom {

    public Ruolo findByDefaultRole();
}
