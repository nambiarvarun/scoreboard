package com.varun.projects.scoreboard.repositories;

import com.varun.projects.scoreboard.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    boolean existsByName(String name);
}