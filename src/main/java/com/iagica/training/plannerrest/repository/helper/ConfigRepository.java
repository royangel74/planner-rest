package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config,Integer> {

    @Query(value = "SELECT c FROM Config c WHERE c.keyname = :keyname AND coalesce(c.expiration,'infinity') > now()")
    public Optional<Config> searchConfigByKeyNameAndExpiration(String keyname);
}
