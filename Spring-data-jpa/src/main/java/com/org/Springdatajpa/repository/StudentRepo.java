package com.org.Springdatajpa.repository;

import com.org.Springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstname);

    List<Student> findByFirstNameContaining(String firstname);

    List<Student> findByGuardianNull();

    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String email);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String email);

    //native query
    @Query(
            value = "select * from tbl_student where email_id=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    //nativequery with Named Param
    @Query(
            value = "select * from tbl_student where guardian_name=:name",
            nativeQuery = true
    )
    Student getStudentByGuardianName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name=:firstname where email_id=:email",
            nativeQuery = true
    )
    void updateStudentFirstNameByEmail(@Param("firstname") String firstname, @Param("email") String emailid);
}
