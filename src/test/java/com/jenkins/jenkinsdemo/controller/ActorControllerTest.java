package com.jenkins.jenkinsdemo.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@Disabled
@WebMvcTest(controllers = ActorController.class)
class ActorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void readUser() throws Exception {

        mockMvc.perform(get("/actors/{id}", "A1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.actorId", is("A1")))
                .andExpect(jsonPath("$.firstName", is("Johnny")))
                .andExpect(jsonPath("$.lastName", is("Depp")))
                .andExpect(jsonPath("$.awards", is("1")));

    }
}
