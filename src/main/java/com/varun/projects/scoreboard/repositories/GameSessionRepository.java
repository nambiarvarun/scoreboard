package com.varun.projects.scoreboard.repositories;

import com.varun.projects.scoreboard.model.GameSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
    List<GameSession> findByGameId(Long gameId);
    List<GameSession> findByCreatedBy(Long playerId);
    List<GameSession> findByWinnerId(Long playerId);
}