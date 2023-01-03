package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.user.User;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserSaveRequestDto requestDto){
        userRepository.create(requestDto.toEntity());
    }
    public void update(int uid, UserUpdateRequestDto requestDto){
        User user = userRepository.getUserById(uid);
        userRepository.update(user.update(requestDto.getName(), requestDto.getEmail()));
    }
    public void updatePW(int uid, UserUpdateRequestDto requestDto){
        User user = userRepository.getUserById(uid);
        userRepository.update(user.updatePw(requestDto.getUser_pw()));
    }
    public void delete(int uid){
        User user  = userRepository.getUserById(uid);
        userRepository.delete(user);
    }
    public UserResponseDto findById(int uid){
        User user = userRepository.getUserById(uid);
        return new UserResponseDto(user);
    }
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllDesc(){
        return userRepository.findAllDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
