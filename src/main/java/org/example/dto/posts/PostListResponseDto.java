package org.example.dto.posts;

import lombok.Getter;
import org.example.domain.posts.Post;


@Getter
public class PostListResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostListResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }


}
