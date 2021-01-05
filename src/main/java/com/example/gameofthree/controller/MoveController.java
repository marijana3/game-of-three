package com.example.gameofthree.controller;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.model.Move;
import com.example.gameofthree.model.request.MoveRequest;
import com.example.gameofthree.model.response.GameResponse;
import com.example.gameofthree.service.GameService;
import com.example.gameofthree.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MoveController {

    @Autowired
    private MoveService moveService;
    @Autowired
    private GameService gameService;

    @GetMapping("/games/{id}/moves")
    public List<Move> getAllMoves(@PathVariable Long id) {
        return moveService.getAllMoves(id);
    }

    @GetMapping("/games/{gameID}/moves/{id}")
    public Optional<Move> getMove(@PathVariable Long gameID, @PathVariable Long id) {
        return moveService.getMove(id);
    }

    public ResponseEntity<GameResponse> computerMove(Integer number, Game game, Boolean newGame) {

        if (number == 1) {
            game.setGameOver(true);
            gameService.updateGame(game.getId(), game);
            return ResponseEntity.ok().body(new GameResponse(game, 1, null, "Game over!"));
        }

        int addedNumber;
        if (number % 3 == 0) {
            addedNumber = 0;
        } else if (number % 3 == 1) {
            addedNumber = -1;
        } else {
            addedNumber = 1;
        }

        int currentNumber = (number + addedNumber)/3;

        Move move = new Move("computer", game, number, addedNumber);
        moveService.createMove(move);

        if (currentNumber == 1) {
            game.setGameOver(true);
            gameService.updateGame(game.getId(), game);
            return ResponseEntity.ok().body(new GameResponse(game, 1, null, "Game over!"));
        }

        String message = "";
        if (newGame) {
            message = "Human has started the game!";
        }
        return ResponseEntity.ok().body(new GameResponse(game, currentNumber, move, message));

    }

    @PostMapping("/humanMove")
    public ResponseEntity<GameResponse> humanMove(@RequestBody MoveRequest moveRequest) {

        Integer number = moveRequest.getCurrentNumber();
        Optional<Game> findGame = gameService.getGame(moveRequest.getGameId());
        Game game = findGame.get();
        if (number == 1) {
            game.setGameOver(true);
            gameService.updateGame(game.getId(), game);
            return  ResponseEntity.ok().body(new GameResponse(game, 1, null, "Game over!"));
        }

        Integer addedNumber = moveRequest.getAddedNumber();

        if (addedNumber != 1 && addedNumber != -1 && addedNumber != 0) {
            return ResponseEntity.badRequest().body(new GameResponse("Invalid input! Enter either 1, -1 or 0!"));
        }

        Integer currentNumber = (number + addedNumber)/3;

        if ((number + addedNumber) % 3 != 0) {
            return ResponseEntity.badRequest().body(new GameResponse("Number " + (number + addedNumber) + " isn't devisible by 3. Please add different number to the number " + number));
        }

        Move move = new Move("human", game, number, addedNumber);
        moveService.createMove(move);

        return computerMove(currentNumber, game, false);

    }
}
