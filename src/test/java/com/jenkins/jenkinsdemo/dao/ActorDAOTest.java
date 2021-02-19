package com.jenkins.jenkinsdemo.dao;

import com.jenkins.jenkinsdemo.exception.ActorNotFoundException;
import com.jenkins.jenkinsdemo.model.Actor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorDAOTest {

    static List<Actor> actorList;
    static ActorDAO actorDAO;

    @BeforeAll
    static void init() {
        actorList = ActorDAO.intiList();
        actorDAO = new ActorDAO(actorList);
    }

    @Test
    void createActorSuccess() throws ActorNotFoundException {
        Actor actor = new Actor();
        actor.setActorId("A9");
        actor.setFirstName("Anakin");
        actor.setLastName("Skywalker");
        actor.setAwards(3);

        actorDAO.createActor(actor);
        assertEquals(actorDAO.readActor(actor.getActorId()).get(0), actor);
    }

    @Test
    void readActorSuccess() throws ActorNotFoundException {
        Actor fetched = actorDAO.readActor("A1").get(0);
        assertEquals(fetched.getActorId(), "A1");
        assertEquals(fetched.getFirstName(), "Johnny");
        assertEquals(fetched.getLastName(), "Depp");
        assertEquals(fetched.getAwards(), 3);
    }

    @Test
    void updateActorTest() throws ActorNotFoundException {

        Actor actor5 = new Actor();
        actor5.setActorId("A5");
        actor5.setFirstName("Mila");
        actor5.setLastName("Kulnis");
        actor5.setAwards(5);

        actorDAO.updateActor(actor5, actor5.getActorId());
        assertEquals(actor5, actorDAO.readActor(actor5.getActorId()).get(0));
    }

    @Test
    void deleteActorTest() throws ActorNotFoundException {
        actorDAO.deleteActor("A6");
        assertThrows(ActorNotFoundException.class, () -> actorDAO.readActor("A6"));
    }
}
