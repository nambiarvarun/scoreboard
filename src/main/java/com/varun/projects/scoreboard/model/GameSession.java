package com.varun.projects.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("GAME_SESSIONS")
public class GameSession {
    @Id
    private Long sessionId;
    private Long gameId;
    private String createdBy; // playerId of the creator
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long winnerId;
}