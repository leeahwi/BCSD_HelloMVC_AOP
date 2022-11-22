package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.user.User;
import org.example.dto.posts.PostsListResponseDto;
import org.example.dto.posts.PostsResponseDto;
import org.example.dto.posts.PostsSaveRequestDto;
import org.example.dto.posts.PostsUpdateRequestDto;
import org.example.dto.user.UserListResponseDto;
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
    public Long update(Long id, UserUpdateRequestDto requestDto){

        User user = userRepository.getUserById(id);
        userRepository.update(user.update(requestDto.getName(), requestDto.getNickName()));
        //id 반환?
        return id;
    }
    public void delete(Long id){
        User user  = userRepository.getUserById(id);

        userRepository.delete(user);
    }

    public UserResponseDto findById(Long id){
        User user = userRepository.getUserById(id);

        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserListResponseDto> findAllDesc(){
        return userRepository.findAllDesc().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }
}
