package com.example.gameofthree.model.request;


public class MoveRequest {

    private Long gameId;
    private Integer currentNumber;
    private Integer addedNumber;

    public MoveRequest() {

    }

    public MoveRequest(Long gameId, Integer currentNumber, Integer addedNumber) {
        this.gameId = gameId;
        this.currentNumber = currentNumber;
        this.addedNumber = addedNumber;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getAddedNumber() {
        return addedNumber;
    }

    public void setAddedNumber(Integer addedNumber) {
        this.addedNumber = addedNumber;
    }
}
