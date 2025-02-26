package com.varun.projects.scoreboard.services;

import com.varun.projects.scoreboard.model.Leaderboard;
import com.varun.projects.scoreboard.repositories.LeaderboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {
    private final LeaderboardRepository leaderboardRepository;

    public List<Leaderboard> getLeaderboardByGame(Long gameId) {
        return leaderboardRepository.findByGameIdOrderByTotalScoreDesc(gameId);
    }

    public List<Leaderboard> getPlayerStats(Long playerId) {
        return leaderboardRepository.findByPlayerId(playerId);
    }

    public void updateLeaderboard(Long gameId, Long playerId, int scoreChange) {
        Leaderboard leaderboard = leaderboardRepository.findByGameIdAndPlayerId(gameId, playerId)
                .orElse(new Leaderboard(null, gameId, playerId, 0));
        leaderboard.setTotalScore(leaderboard.getTotalScore() + scoreChange);
        leaderboardRepository.save(leaderboard);
    }
}