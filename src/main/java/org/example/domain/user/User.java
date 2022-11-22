package org.example.domain.user;
import lombok.*;
import org.example.domain.BaseTimeEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    //키 값
    private Long id;

    //속성
    private String name;
    private String password;
    private Long schoolNumber;
    private String nickName;
    private String phoneNumber;
    private String gender;
    private String email;
    private String picture;
    private Role role = Role.GUEST;

    public User update(String name, String nickName){
        this.name = name;
        this.nickName = nickName;
        return this;
    }

    public String getRoleKey(){
        return this.getRole().getKey();
    }

}
