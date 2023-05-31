package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.dto.response.UserRoleFunctionResponse;
import com.iagica.training.plannerrest.domain.model.helper.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>,UserRepositoryCustom{

    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.username = :username")
    Optional<User> searchUserWithRole(String username);

    Optional<User> findByUsername(String username);
}
