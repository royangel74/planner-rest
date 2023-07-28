package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Function;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRole;
import com.iagica.training.plannerrest.domain.model.helper.FunctionRolePK;
import com.iagica.training.plannerrest.domain.model.helper.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class FunctionRoleRepositoryCustomImpl implements FunctionRoleRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * @return
     */
    @Override
    public boolean searchFunctionRoleWhitEmailAndRoleAndAccess() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FunctionRole> query = cb.createQuery(FunctionRole.class);
        Root<FunctionRole> functionRolePKRoot = query.from(FunctionRole.class);
        Root<Function> functionRoot = query.from(Function.class);
        Root<User> userRoot = query.from(User.class);
        Join<User,FunctionRole> functionRolePKUserJoin = userRoot.join("functionRolePK", JoinType.INNER);
        query.select(functionRolePKRoot).where(cb.equal(userRoot.get("username"), "user@mail.com"), cb.equal(functionRoot.get("typeFunction"), "DELETE"));
        List<FunctionRole> functionRole = entityManager.createQuery(query).getResultList();
        log.info("-------------------------------------------------------->"+functionRole);
        return false;
    }
}
