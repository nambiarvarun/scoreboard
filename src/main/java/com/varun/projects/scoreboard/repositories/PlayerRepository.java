package com.varun.projects.scoreboard.repositories;

import com.varun.projects.scoreboard.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    //List<Player> findByGameId(Long gameId);
}