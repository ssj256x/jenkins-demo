package com.jenkins.jenkinsdemo.config;

import com.jenkins.jenkinsdemo.dao.ActorDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ActorDAO actorDAO() {
        return new ActorDAO(ActorDAO.intiList());
    }
}
