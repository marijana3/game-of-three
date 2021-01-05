package com.example.gameofthree.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerStarted;
    @Column(columnDefinition = "boolean default false")
    private Boolean gameOver = false;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate = new Date();

    public Game() {

    }

    public Game(String playerStarted) {
        this.playerStarted = playerStarted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerStarted() {
        return playerStarted;
    }

    public void setPlayerStarted(String playerStarted) {
        this.playerStarted = playerStarted;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
