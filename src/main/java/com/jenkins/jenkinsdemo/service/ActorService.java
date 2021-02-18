package com.jenkins.jenkinsdemo.service;

import com.jenkins.jenkinsdemo.dao.ActorDAO;
import com.jenkins.jenkinsdemo.exception.ActorNotFoundException;
import com.jenkins.jenkinsdemo.model.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorDAO actorDAO;

    public ActorService(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    public void createActor(Actor actor) {
        actorDAO.createActor(actor);
    }

    public List<Actor> readActor(String id) throws ActorNotFoundException {
        return actorDAO.readActor(id);
    }

    public void updateActor(Actor actor, String id) throws ActorNotFoundException {
        actorDAO.updateActor(actor, id);
    }

    public void deleteActor(String id) throws ActorNotFoundException {
        actorDAO.deleteActor(id);
    }
}
