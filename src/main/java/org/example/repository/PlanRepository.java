package org.example.repository;

import org.example.domain.plan.Plan;
import org.example.domain.team.Team;
import org.example.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository {
    Plan getPlanById(int id);
    void create(Plan plan);
    void delete(Plan plan);
    void update(Plan plan);

    List<Plan> findAllDesc();
}
