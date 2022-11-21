package org.example.domain.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private String department;

    public Student(Long id){
        this.id = id;
    }
    public Student(){

    }
}
