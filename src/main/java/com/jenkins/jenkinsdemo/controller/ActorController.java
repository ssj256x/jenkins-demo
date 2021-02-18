package com.jenkins.jenkinsdemo.controller;

import com.jenkins.jenkinsdemo.exception.ActorNotFoundException;
import com.jenkins.jenkinsdemo.model.Actor;
import com.jenkins.jenkinsdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/actors", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createActor(@RequestBody Actor actor) {
        actorService.createActor(actor);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public List<Actor> readActor(@PathVariable String id) throws ActorNotFoundException {
        return actorService.readActor(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PatchMapping
    public void updateActor(@RequestBody Actor actor) throws ActorNotFoundException {
        actorService.updateActor(actor, actor.getActorId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable String id) throws ActorNotFoundException {
        actorService.deleteActor(id);
    }
}
