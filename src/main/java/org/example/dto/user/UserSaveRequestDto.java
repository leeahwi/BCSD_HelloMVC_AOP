package org.example.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.user.Role;
import org.example.domain.user.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    private Long id;
    private String name;
    private String password;
    private Long schoolNumber;
    private String nickName;
    private String phoneNumber;

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .password(password)
                .schoolNumber(schoolNumber)
                .nickName(nickName)
                .phoneNumber(phoneNumber)
                .build();
    }
}
