package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Post;
import org.example.repository.PostRepository;
import org.example.dto.posts.PostListResponseDto;
import org.example.dto.posts.PostResponseDto;
import org.example.dto.posts.PostSaveRequestDto;
import org.example.dto.posts.PostUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;

    public void save(PostSaveRequestDto requestDto){
        postRepository.create(requestDto.toEntity());
    }
    public Long update(Long id, PostUpdateRequestDto requestDto){

        Post posts = postRepository.getPostsById(id);

        posts.update(requestDto.getTitle(), requestDto.getContent());
        postRepository.update(posts);
        return id;
    }
    public void delete(Long id){
        Post posts = postRepository.getPostsById(id);
        postRepository.delete(posts);
    }

    public PostResponseDto findById(Long id){
        Post entity = postRepository.getPostsById(id);
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

}
