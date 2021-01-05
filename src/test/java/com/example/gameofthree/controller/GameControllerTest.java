package com.example.gameofthree.controller;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllGamesTest() throws Exception {

        Game game1 = new Game("computer");
        Game game2 = new Game("human");
        List<Game> allGames = Arrays.asList(game1, game2);

        given(gameService.getAllGames()).willReturn(allGames);

        mockMvc.perform(get("/games")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(allGames)))
                .andExpect(status().isOk());
    }

}