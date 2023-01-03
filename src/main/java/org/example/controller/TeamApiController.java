package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.example.dto.team.TeamResponseDto;
import org.example.dto.team.TeamSaveRequestDto;
import org.example.dto.team.TeamUpdateRequestDto;
import org.example.service.PlanService;
import org.example.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamApiController {
    private final TeamService teamService;
    @PostMapping("/api/v1/team")
    public void save(@RequestBody TeamSaveRequestDto requestDto){
        teamService.save(requestDto);
    }
    @PutMapping("/api/v1/team/{id}")
    public void update(@PathVariable int id, @RequestBody TeamUpdateRequestDto requestDto){
        teamService.updateName(id,requestDto);
    }
    @DeleteMapping("/api/v1/team/{id}")
    public int delete(@PathVariable int id){
        teamService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/team/{id}")
    public TeamResponseDto findById(@PathVariable int id){
        return teamService.findById(id);
    }
}
