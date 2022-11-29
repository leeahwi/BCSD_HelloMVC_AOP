package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.PostService;
import org.example.dto.posts.PostResponseDto;
import org.example.dto.posts.PostSaveRequestDto;
import org.example.dto.posts.PostUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postsService;

    @PostMapping("/api/v1/posts")
    public void save(@RequestBody PostSaveRequestDto requestDto){
        postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        postsService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
