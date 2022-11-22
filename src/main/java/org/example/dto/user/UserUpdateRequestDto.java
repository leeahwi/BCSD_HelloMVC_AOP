package org.example.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String name;
    private String nickName;

    public UserUpdateRequestDto(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }
}

