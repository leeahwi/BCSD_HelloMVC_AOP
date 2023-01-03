package org.example.repository;

import org.example.domain.team.Team;
import org.example.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository {
    Team getTeamById(int id);
    void create(Team team);
    void delete(Team team);
    void update(Team team);

    List<Team> findAllDesc();
}
