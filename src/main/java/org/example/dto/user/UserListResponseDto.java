package org.example.dto.user;

import lombok.Getter;
import org.example.domain.user.User;


@Getter
public class UserListResponseDto {
    private final Long id;
    private final String name;
    private final Long schoolNumber;
    private final String nickName;
    private final String phoneNumber;

    public UserListResponseDto(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.schoolNumber = entity.getSchoolNumber();
        this.nickName = entity.getNickName();
        this.phoneNumber = entity.getPhoneNumber();

    }


}
