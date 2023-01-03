package org.example.dto.team;

import lombok.Getter;
import org.example.domain.team.Team;
import org.example.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class TeamResponseDto {
    private int tid;
    private String name;
    private String invite_link;
    private LocalDateTime create_link_date;

    public TeamResponseDto(Team entity) {
        this.tid = entity.getTid();
        this.name = entity.getName();
        this.invite_link = entity.getInvite_link();
        this.create_link_date = entity.getCreate_link_date();
    }
}
