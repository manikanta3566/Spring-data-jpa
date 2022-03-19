package com.org.Springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

//    @Id
//    @SequenceGenerator(
//            name = "teacher_sequence",
//            sequenceName = "teacher_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "teacher_sequence"
//    )
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String firstName;
    private String lastName;
//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;

//    public Teacher(String firstName, String lastName, List<Course> courses) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.courses = courses;
//    }


}
