package com.varun.projects.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("LEADERBOARDS")
public class Leaderboard {
    @Id
    private Long leaderboardId;
    private Long gameId;
    private Long playerId;
    private int totalScore;
}