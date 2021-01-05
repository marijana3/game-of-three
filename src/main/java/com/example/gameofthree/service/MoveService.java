package com.example.gameofthree.service;

import com.example.gameofthree.model.Game;
import com.example.gameofthree.model.Move;
import com.example.gameofthree.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveService {

    @Autowired
    private MoveRepository moveRepository;

    public List<Move> getAllMoves(Long id) {
        return moveRepository.findAllByGameId(id);
    }

    public Optional<Move> getMove(Long id) {
        return moveRepository.findById(id);
    }

    public void createMove(Move move) {
        moveRepository.save(move);
    }

}
