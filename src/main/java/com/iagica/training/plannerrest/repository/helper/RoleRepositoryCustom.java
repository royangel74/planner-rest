package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Role;

import java.util.Optional;

public interface RoleRepositoryCustom {
    public Optional<Role> findRoleDefault(String role);
}
