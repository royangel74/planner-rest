package com.iagica.training.plannerrest.repository.planner;

import com.iagica.training.plannerrest.domain.dto.request.AgendaDisponibilitaRequest;
import com.iagica.training.plannerrest.domain.dto.request.AgendaRequest;
import com.iagica.training.plannerrest.domain.dto.response.AgendaResponse;
import com.iagica.training.plannerrest.domain.model.helper.User;
import com.iagica.training.plannerrest.domain.model.planner.Agenda;
import com.iagica.training.plannerrest.domain.model.planner.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.List;

public class AgendaRepositoryCustomImpl implements AgendaRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    /**
     * @param agendaRequest
     * @return
     */
    @Override
    public List<Agenda> findByAgenda(AgendaDisponibilitaRequest agendaRequest) {

        Integer id = agendaRequest.getUser();

        if(agendaRequest.getMasterEndDate() == null){
            agendaRequest.setMasterEndDate(agendaRequest.getMasterDate());
        }

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Agenda> query = cb.createQuery(Agenda.class);
        Root<Agenda> agenda = query.from(Agenda.class);
        Root<Event> events = query.from(Event.class);
        Join<Agenda, Event> event = agenda.join("event", JoinType.INNER);
        Join<Event, User>  users = events.join("user",JoinType.INNER);
        query.select(agenda).where(cb.and(
                cb.between(agenda.get("masterDate"),agendaRequest.getMasterDate(),agendaRequest.getMasterEndDate()),
                cb.between(agenda.get("eventStart"),agendaRequest.getStartEventTime(),agendaRequest.getEndEventTime()),
                //  cb.equal(agenda.get("eventPublic"),agendaRequest.isEventPublic()),
                cb.equal(users.get("uidUser"),id)));

        List<Agenda> agenda1 = entityManager.createQuery(query).getResultList().stream().toList();

        return agenda1;
    }
}
