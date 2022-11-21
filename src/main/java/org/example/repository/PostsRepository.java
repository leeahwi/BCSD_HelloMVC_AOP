package org.example.repository;

import org.apache.ibatis.annotations.Param;
import org.example.domain.posts.Posts;
import org.example.domain.student.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository{

    Posts getPostsById(Long id);

    void create(Posts posts);

    void delete(Posts posts);

    void update(Posts posts);

    List<Posts> findAllDesc();
}
