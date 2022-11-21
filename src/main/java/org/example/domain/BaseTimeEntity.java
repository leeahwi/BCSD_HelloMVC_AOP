package org.example.domain;

import jdk.jfr.Timestamp;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter //get 함수 자동 생성
public abstract class BaseTimeEntity {

    @CreatedDate  //Entity 생성시 시간 자동 저장
    private LocalDateTime createDate;   //만들때 시간, 생성시간

    @LastModifiedDate   //Entity 수정시 시간 자동 저장
    private LocalDateTime modifiedDate; //수정할때 시간, 수정시간

}
