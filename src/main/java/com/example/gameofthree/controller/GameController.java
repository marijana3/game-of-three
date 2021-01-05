package com.example.gameofthree.controller;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.model.response.GameResponse;
import com.example.gameofthree.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private MoveController moveController;

    private static final int MAX = 10000;
    private static final Random random = new Random();

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Optional<Game> getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @GetMapping("/lastFinishedGame")
    public Game getLastFinishedGame() {
        return gameService.getLastFinishedGame();
    }

    @PostMapping("/newGame/{player}")
    public ResponseEntity<GameResponse> createGame(@PathVariable String player) {

        Game game = new Game(player);
        gameService.createGame(game);

        int startingNumber = random.nextInt(MAX) + 1;

        if (player.equals("computer")) {
            return ResponseEntity.ok().body(new GameResponse(game, startingNumber, null, "Computer has started the game!"));
        } else {
            return moveController.computerMove(startingNumber, game, true);
        }
    }
}
