package com.example.gameofthree.repository;

import com.example.gameofthree.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findTopByGameOverOrderByIdDesc(Boolean gameOver);
}
