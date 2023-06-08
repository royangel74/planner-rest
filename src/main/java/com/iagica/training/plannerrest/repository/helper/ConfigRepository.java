package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Config;
import com.iagica.training.plannerrest.domain.model.helper.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Integer> {

    Optional<Config> searchByKeyNameNoExpiration(String keyName);

}
