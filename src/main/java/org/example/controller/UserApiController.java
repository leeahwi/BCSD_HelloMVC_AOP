package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public void save(@RequestBody UserSaveRequestDto requestDto){userService.save(requestDto);
    }

    @PutMapping("/api/v1/user/{id}")
    public void update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        userService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id){
        userService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
