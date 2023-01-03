package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.team.Team;
import org.example.dto.team.TeamResponseDto;
import org.example.dto.team.TeamSaveRequestDto;
import org.example.dto.team.TeamUpdateRequestDto;
import org.example.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public void save(TeamSaveRequestDto requestDto){
        teamRepository.create(requestDto.toEntity());
    }
    public void updateName(int tid, TeamUpdateRequestDto requestDto){
        Team team = teamRepository.getTeamById(tid);
        teamRepository.update(team.update(requestDto.getName()));
    }
    public void delete(int tid){
        Team team = teamRepository.getTeamById(tid);
        teamRepository.delete(team);
    }
    public TeamResponseDto findById(int tid){
        Team team = teamRepository.getTeamById(tid);
        return new TeamResponseDto(team);
    }
    @Transactional(readOnly = true)
    public List<TeamResponseDto> findAllDesc(){
        return teamRepository.findAllDesc().stream()
                .map(TeamResponseDto::new)
                .collect(Collectors.toList());
    }
}
