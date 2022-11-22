package org.example.dto.user;

import lombok.Getter;
import org.example.domain.posts.Posts;
import org.example.domain.user.Role;
import org.example.domain.user.User;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Long schoolNumber;
    private String nickName;
    private String phoneNumber;
    private String gender;
    private String email;
    private String picture;
    private Role role;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.schoolNumber = entity.getSchoolNumber();
        this.nickName = entity.getNickName();
        this.phoneNumber = entity.getPhoneNumber();
        this.gender = entity.getGender();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
    }
}
