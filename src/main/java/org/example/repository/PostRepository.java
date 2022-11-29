package org.example.repository;

import org.example.domain.posts.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {

    Post getPostsById(Long id);

    void create(Post posts);

    void delete(Post posts);

    void update(Post posts);

    List<Post> findAllDesc();
}
