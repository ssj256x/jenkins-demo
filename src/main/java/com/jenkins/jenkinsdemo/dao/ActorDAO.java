package com.jenkins.jenkinsdemo.dao;

import com.jenkins.jenkinsdemo.exception.ActorNotFoundException;
import com.jenkins.jenkinsdemo.model.Actor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ActorDAO {

    private final List<Actor> actorList;

    public ActorDAO(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public void createActor(Actor actor) {
        actorList.add(actor);
    }

    public List<Actor> readActor(String id) throws ActorNotFoundException {
        if (id == null || id.equals("")) return actorList;
        return Collections.singletonList(findActorById(id));

    }

    public void updateActor(Actor actor, String id) throws ActorNotFoundException {
        Actor updated = findActorById(id);
        actorList.remove(updated);
        actorList.add(actor);
    }

    public void deleteActor(String id) throws ActorNotFoundException {
        actorList.remove(findActorById(id));
    }

    private Actor findActorById(String id) throws ActorNotFoundException {
        return actorList
                .stream()
                .filter(actor -> actor.getActorId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ActorNotFoundException("Actor not found"));
    }

    public static List<Actor> intiList() {
        Actor actor1 = new Actor();
        actor1.setActorId("A1");
        actor1.setFirstName("Johnny");
        actor1.setLastName("Depp");
        actor1.setAwards(3);

        Actor actor2 = new Actor();
        actor2.setActorId("A2");
        actor2.setFirstName("Emma");
        actor2.setLastName("Stone");
        actor2.setAwards(5);

        Actor actor3 = new Actor();
        actor3.setActorId("A3");
        actor3.setFirstName("Keanu");
        actor3.setLastName("Reeves");
        actor3.setAwards(1);


        Actor actor4 = new Actor();
        actor4.setActorId("A4");
        actor4.setFirstName("Daniel");
        actor4.setLastName("Craig");
        actor4.setAwards(3);

        Actor actor5 = new Actor();
        actor5.setActorId("A5");
        actor5.setFirstName("Paris");
        actor5.setLastName("Hilton");
        actor5.setAwards(3);

        Actor actor6 = new Actor();
        actor6.setActorId("A6");
        actor6.setFirstName("Emma");
        actor6.setLastName("Watson");
        actor6.setAwards(3);

        List<Actor> list = new ArrayList<>();
        list.add(actor1);
        list.add(actor2);
        list.add(actor3);
        list.add(actor4);
        list.add(actor5);
        list.add(actor6);

        return list;
    }
}
