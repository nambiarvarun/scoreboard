package com.varun.projects.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("SCORES")
public class Score {
    @Id
    private Long scoreId;
    private Long sessionId;
    private Long playerId;
    private int score;
}