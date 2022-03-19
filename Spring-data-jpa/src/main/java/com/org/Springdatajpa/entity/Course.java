package com.org.Springdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
//    @Id
//    @SequenceGenerator(
//            name = "course_sequence",
//            sequenceName = "course_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "course_sequence"
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private  Teacher teacher;

   @ManyToMany(
           cascade = CascadeType.ALL
   )
            @JoinTable(
                    name = "course_student_mapping",
                    joinColumns = @JoinColumn(
                            name ="course_id",
                    referencedColumnName = "courseId"
                    ),
                    inverseJoinColumns =@JoinColumn(
                            name = "student_id",
                            referencedColumnName = "studentId"
                    )
            )
    List<Student> students;



}
