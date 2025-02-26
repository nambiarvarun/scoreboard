package com.varun.projects.scoreboard.services;

import com.varun.projects.scoreboard.model.Score;
import com.varun.projects.scoreboard.repositories.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public Score updateScore(Long playerId, Long gameSessionId, int delta) {
        Score score = scoreRepository.findByPlayerIdAndSessionId(playerId, gameSessionId)
                .stream().findFirst()
                .orElse(new Score(null, gameSessionId, playerId, 0));

        score.setScore(score.getScore() + delta);
        return scoreRepository.save(score);
    }

    public List<Score> getScoresByGameSession(Long sessionId) {
        return scoreRepository.findBySessionId(sessionId);
    }
}