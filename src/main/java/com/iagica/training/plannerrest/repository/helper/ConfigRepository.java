package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Integer> {

    @Query(value = "select c from Config c where c.keyname = :keyName AND coalesce(c.expiration , 'infinity') > now()")
    Optional<Config> searchByKeyNameNoExpiration(String keyName);
}
