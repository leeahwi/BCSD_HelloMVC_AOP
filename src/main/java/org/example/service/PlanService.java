package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.plan.Plan;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.example.repository.PlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public void save(PlanSaveRequestDto requestDto){
        planRepository.create(requestDto.toEntity());
    }
    public void updateMemo(int pid, PlanUpdateRequestDto requestDto){
        Plan plan = planRepository.getPlanById(pid);
        planRepository.update(plan.updateMemo(requestDto.getMemo()));
    }
    public void updateTime(int pid, PlanUpdateRequestDto requestDto){
        Plan plan = planRepository.getPlanById(pid);
        planRepository.update(plan.updateTime(requestDto.getStart_time(),requestDto.getEnd_time()));
    }
    public void delete(int pid){
        Plan plan  = planRepository.getPlanById(pid);
        planRepository.delete(plan);
    }
    public PlanResponseDto findById(int pid){
        Plan plan  = planRepository.getPlanById(pid);
        return new PlanResponseDto(plan);
    }
    @Transactional(readOnly = true)
    public List<PlanResponseDto> findAllDesc(){
        return planRepository.findAllDesc().stream()
                .map(PlanResponseDto::new)
                .collect(Collectors.toList());
    }
}
