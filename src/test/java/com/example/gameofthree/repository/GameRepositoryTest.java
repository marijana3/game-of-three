package com.example.gameofthree.repository;

import com.example.gameofthree.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void whenfindLastUnfinishedGame_thenReturnGame() {
        Game game = new Game("computer");
        entityManager.persist(game);
        entityManager.flush();

        Game foundGame = gameRepository.findTopByGameOverOrderByIdDesc(false);

        assertEquals(foundGame.getId(), game.getId());
    }
}