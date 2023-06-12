package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRole;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRolePK;
import com.iagica.training.plannerrest.domain.model.helper.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FunctionRoleRepository extends JpaRepository<FunctionRole,Integer>,FunctionRoleRepositoryCustom {
    public List<FunctionRole> findByfunctionRolePK(FunctionRolePK functionRolePK);
   @Query("SELECT f FROM FunctionRole f INNER JOIN User u ON u.role = f.functionRolePK.uidrole " +
           "INNER JOIN Function fc ON fc.idFunction = f.functionRolePK.uidfunction " +
           "WHERE u.username = :username " +
           "AND fc.typeFunction = :typeFunction " +
           "AND f.access LIKE %:access%")
    public FunctionRole searchFunctionRoleWhitEmailAndTypeFunctionAndStringAccess(String username,String typeFunction,String access);
}
