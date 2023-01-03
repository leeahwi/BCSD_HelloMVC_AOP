package org.example.dto.plan;

import org.example.domain.plan.Plan;
import org.example.domain.team.Team;

import java.time.LocalDateTime;

public class PlanResponseDto {
    private int pid;
    private String title;

    private String memo;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    private LocalDateTime replan_time;

    public PlanResponseDto(Plan entity) {
        this.pid = entity.getPid();
        this.title = entity.getTitle();
        this.memo = entity.getMemo();
        this.start_time = entity.getStart_time();
        this.end_time = entity.getEnd_time();
        this.replan_time = entity.getReplan_time();
    }
}
