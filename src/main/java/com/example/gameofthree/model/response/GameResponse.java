package com.example.gameofthree.model.response;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.model.Move;

import javax.persistence.Column;

public class GameResponse {

    private Game game;
    private Integer sentNumber;
    private Move move;
    private String message;

    public GameResponse() {

    }

    public GameResponse(Game game, Integer sentNumber, Move move, String message) {
        this.game = game;
        this.sentNumber = sentNumber;
        this.move = move;
        this.message = message;
    }

    public GameResponse(String message) {
        this.message = message;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getSentNumber() {
        return sentNumber;
    }

    public void setSentNumber(Integer sentNumber) {
        this.sentNumber = sentNumber;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
