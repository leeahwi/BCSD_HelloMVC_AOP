package org.example.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    private int uid;
    private String name;
    private String email;

    private String user_id;
    private String user_pw;

    public User toEntity(){
        return User.builder()
                .uid(uid)
                .name(name)
                .email(email)
                .user_id(user_id)
                .user_pw(user_pw)
                .build();
    }
}
