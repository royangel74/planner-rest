package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Role;
import com.iagica.training.plannerrest.domain.model.helper.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Ruolo, Integer>, RoleRepositoryCustom {

    Optional<Role> findByIdrole(String keyValue);
}
