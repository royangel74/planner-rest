package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Role;
import com.iagica.training.plannerrest.domain.model.planner.Agenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RoleRepositoryCustomImpl implements RoleRepositoryCustom {

    private static final String DefaultRole = "USER";
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Role findRoleDefault() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> role = query.from(Role.class);
        query.select(role).where(role.get("ruolo").in(DefaultRole));

        Role ruolo = entityManager.createQuery(query).getSingleResult();
        return ruolo;
    }
}