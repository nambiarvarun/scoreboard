package com.varun.projects.scoreboard.repositories;

import com.varun.projects.scoreboard.model.Leaderboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaderboardRepository extends CrudRepository<Leaderboard, Long> {
    List<Leaderboard> findByGameIdOrderByTotalScoreDesc(Long gameId);

    List<Leaderboard> findByPlayerId(Long playerId);

    Optional<Leaderboard> findByGameIdAndPlayerId(Long gameId, Long playerId);
}