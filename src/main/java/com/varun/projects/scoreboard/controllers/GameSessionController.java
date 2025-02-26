package com.varun.projects.scoreboard.controllers;

import com.varun.projects.scoreboard.model.GameSession;
import com.varun.projects.scoreboard.services.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-sessions")
@RequiredArgsConstructor
@CrossOrigin
public class GameSessionController {
    private final GameSessionService gameSessionService;

    @PostMapping
    public ResponseEntity<GameSession> createGameSession(@RequestBody GameSession gameSession) {
        return ResponseEntity.ok(gameSessionService.createGameSession(gameSession));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<GameSession>> getSessionsByGame(@PathVariable Long gameId) {
        return ResponseEntity.ok(gameSessionService.getSessionsByGame(gameId));
    }

    @PutMapping("/{sessionId}/end")
    public ResponseEntity<GameSession> endSession(@PathVariable Long sessionId) {
        return ResponseEntity.ok(gameSessionService.endSession(sessionId));
    }

}