package org.example.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.plan.Plan;
import org.example.domain.team.Team;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanSaveRequestDto {
    private int pid;
    private String title;

    private String memo;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    private LocalDateTime replan_time;

    public Plan toEntity(){
        return Plan.builder()
                .pid(pid)
                .title(title)
                .memo(memo)
                .start_time(start_time)
                .end_time(end_time)
                .replan_time(replan_time)
                .build();
    }
}
