package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.repository.PostsRepository;
import org.example.dto.posts.PostsListResponseDto;
import org.example.dto.posts.PostsResponseDto;
import org.example.dto.posts.PostsSaveRequestDto;
import org.example.dto.posts.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public void save(PostsSaveRequestDto requestDto){
        postsRepository.create(requestDto.toEntity());
    }
    public Long update(Long id, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.getPostsById(id);
//                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        postsRepository.update(posts);
        //id 반환?
        return id;
    }
    public void delete(Long id){
        Posts posts = postsRepository.getPostsById(id);
//                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.getPostsById(id);
//                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
