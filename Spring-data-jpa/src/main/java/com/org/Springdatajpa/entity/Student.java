package com.org.Springdatajpa.entity;

import com.org.Springdatajpa.repository.Guardian;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "emailId"
        )
)
public class Student {
//    @Id
//    @SequenceGenerator(
//            name = "sequenceName",
//            sequenceName = "sequenceName",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "sequenceName"
//    )
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "firstName",
            nullable = false)
    private String firstName;
    private String lastName;
    private String emailId;

    @Embedded
    private Guardian guardian;
}
