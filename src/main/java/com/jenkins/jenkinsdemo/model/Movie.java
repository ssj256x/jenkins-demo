package com.jenkins.jenkinsdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Movie {

    private String movieId;
    private String movieName;
    private String movieDescription;
    private LocalDate releaseDate;
    private String genre;
}
