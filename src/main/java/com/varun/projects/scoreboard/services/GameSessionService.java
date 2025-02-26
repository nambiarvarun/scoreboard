package com.varun.projects.scoreboard.services;

import com.varun.projects.scoreboard.model.GameSession;
import com.varun.projects.scoreboard.model.Score;
import com.varun.projects.scoreboard.repositories.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameSessionService {
    private final GameSessionRepository gameSessionRepository;

    private final LeaderboardService leaderboardService;

    private final ScoreService scoreService;

    public GameSession createGameSession(GameSession gameSession) {
        gameSession.setStartTime(LocalDateTime.now());
        return gameSessionRepository.save(gameSession);
    }

    public List<GameSession> getSessionsByGame(Long gameId) {
        return gameSessionRepository.findByGameId(gameId);
    }

    public GameSession endSession(Long sessionId) {
        GameSession session = gameSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setEndTime(LocalDateTime.now());

        Long winnerId = 0L;;
        int maxScore = 0;
        // Get final scores and update leaderboard
        List<Score> sessionScores = scoreService.getScoresByGameSession(sessionId);
        for (Score score : sessionScores) {
            if (score.getScore() > maxScore) {
                maxScore = score.getScore();
                winnerId = score.getPlayerId();
            }
            leaderboardService.updateLeaderboard(
                    session.getGameId(),
                    score.getPlayerId(),
                    score.getScore()
            );
        }
        session.setWinnerId(winnerId);

        return gameSessionRepository.save(session);
    }
}