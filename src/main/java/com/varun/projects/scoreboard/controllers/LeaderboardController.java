package com.varun.projects.scoreboard.controllers;

import com.varun.projects.scoreboard.model.Leaderboard;
import com.varun.projects.scoreboard.services.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@RequiredArgsConstructor
@CrossOrigin
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Leaderboard>> getGameLeaderboard(@PathVariable Long gameId) {
        return ResponseEntity.ok(leaderboardService.getLeaderboardByGame(gameId));
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Leaderboard>> getPlayerStats(@PathVariable Long playerId) {
        return ResponseEntity.ok(leaderboardService.getPlayerStats(playerId));
    }
}