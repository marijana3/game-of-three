package com.example.gameofthree.service;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGame(Long id) {
        return gameRepository.findById(id);
    }

    public Game getLastFinishedGame() {
        return gameRepository.findTopByGameOverOrderByIdDesc(true);
    }

    public void createGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(Long id, Game game) {
        gameRepository.save(game);
    }
}
