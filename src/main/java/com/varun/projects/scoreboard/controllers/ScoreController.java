package com.varun.projects.scoreboard.controllers;

import com.varun.projects.scoreboard.model.Score;
import com.varun.projects.scoreboard.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
@CrossOrigin
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping("/update")
    public ResponseEntity<Score> updateScore(
            @RequestParam Long playerId,
            @RequestParam Long gameSessionId,
            @RequestParam int delta) {
        return ResponseEntity.ok(scoreService.updateScore(playerId, gameSessionId, delta));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<Score>> getSessionScores(@PathVariable Long sessionId) {
        return ResponseEntity.ok(scoreService.getScoresByGameSession(sessionId));
    }
}