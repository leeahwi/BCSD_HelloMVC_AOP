package org.example.domain.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Plan {
    private int pid;
    private String title;

    private String memo;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    private LocalDateTime replan_time;

    public Plan updateTime(LocalDateTime newStart, LocalDateTime newEnd){
        this.start_time = newStart;
        this.end_time = newEnd;
        return this;
    }
    public Plan updateMemo(String newMemo){
        this.memo = newMemo;
        return this;
    }
}
