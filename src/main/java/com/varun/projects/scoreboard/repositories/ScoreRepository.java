package com.varun.projects.scoreboard.repositories;

import com.varun.projects.scoreboard.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
    List<Score> findBySessionId(Long sessionId);

    List<Score> findByPlayerIdAndSessionId(Long playerId, Long sessionId);

    List<Score> findByPlayerId(Long playerId);
}