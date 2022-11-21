package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.PostsService;
import org.example.dto.posts.PostsResponseDto;
import org.example.dto.posts.PostsSaveRequestDto;
import org.example.dto.posts.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public void save(@RequestBody PostsSaveRequestDto requestDto){postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        postsService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
