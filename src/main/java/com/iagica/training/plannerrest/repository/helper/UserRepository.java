package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String email);
}
