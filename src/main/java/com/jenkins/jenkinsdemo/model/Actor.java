package com.jenkins.jenkinsdemo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {
    private String actorId;
    private String firstName;
    private String lastName;
    private Integer awards;
}
