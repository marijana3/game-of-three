package com.example.gameofthree.service;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @Test
    public void whenFindAll_thenReturnGamesList() {

        Game game1 = new Game("computer");
        Game game2 = new Game("human");
        List<Game> expectedGames = Arrays.asList(game1, game2);

        doReturn(expectedGames).when(gameRepository).findAll();

        List<Game> actualGames = gameService.getAllGames();

        assertEquals(actualGames, expectedGames);
    }

}