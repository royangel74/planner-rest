package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.Ruolo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RoleRepositoryCustomImpl implements RoleRepositoryCustom {
   private static final String defaultRole = "USER";

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Ruolo findByDefaultRole() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ruolo> query = cb.createQuery(Ruolo.class);
        Root<Ruolo> role = query.from(Ruolo.class);
        query.select(role).where(role.get("ruolo").in(defaultRole));

        Ruolo ruolo = entityManager.createQuery(query).getSingleResult();

        return ruolo;

    }
}
