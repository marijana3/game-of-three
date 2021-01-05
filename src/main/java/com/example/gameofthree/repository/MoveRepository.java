package com.example.gameofthree.repository;

import com.example.gameofthree.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

    List<Move> findAllByGameId(Long id);
}
