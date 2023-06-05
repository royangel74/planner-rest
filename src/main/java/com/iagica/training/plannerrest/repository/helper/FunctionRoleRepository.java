package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRole;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRolePK;
import com.iagica.training.plannerrest.domain.model.helper.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FunctionRoleRepository extends JpaRepository<FunctionRole,Integer> {
  public List<FunctionRole> findByfunctionRolePK(FunctionRolePK functionRolePK);
}
