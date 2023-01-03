package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.example.service.PlanService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlanApiController {
    private final PlanService planService;
    @PostMapping("/api/v1/plan")
    public void save(@RequestBody PlanSaveRequestDto requestDto){
        planService.save(requestDto);
    }
    @PutMapping("/api/v1/plan/memo/{id}")
    public void updateMemo(@PathVariable int id, @RequestBody PlanUpdateRequestDto requestDto){
        planService.updateMemo(id,requestDto);
    }
    @PutMapping("/api/v1/plan/time/{id}")
    public void updateTime(@PathVariable int id, @RequestBody PlanUpdateRequestDto requestDto){
        planService.updateTime(id,requestDto);
    }
    @DeleteMapping("/api/v1/plan/{id}")
    public int delete(@PathVariable int id){
        planService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/plan/{id}")
    public PlanResponseDto findById(@PathVariable int id){
        return planService.findById(id);
    }
}
