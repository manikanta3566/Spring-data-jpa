package com.org.Springdatajpa.repository;

import com.org.Springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    void saveStudent(){
        Student student1=Student.builder()
                .firstName("ramesh")
                .lastName("gowda")
                .emailId("ramesh1234@gmail.com")
                .build();
        studentRepo.save(student1);
        Student student2=Student.builder()
                .firstName("adarsh")
                .lastName("gowda")
                .emailId("adarsh1234@gmail.com")
                .build();
        studentRepo.save(student2);

    }
    @Test
    void saveStudentsWithGuardian(){
        Guardian guardian=Guardian.builder()
                .email("g@gmail.com")
                .name("g")
                .phNo("1234567890")
        .build();
        Student student=Student.builder()
                .firstName("ramesh")
                .lastName("gowda")
                .emailId("ramesh12345@gmail.com")
                .guardian(guardian)
                .build();
        studentRepo.save(student);
    }
@Test
    void getAllStudents(){
    List<Student> studentList = studentRepo.findAll();
    studentList.forEach(System.out::println);
}
@Test
public void findStudentByFirstName(){
    List<Student> students = studentRepo.findByFirstName("ramesh");
    System.out.println("students->" + students);
}
    @Test
    public void findStudentByFirstNameContaining(){
        List<Student> students = studentRepo.findByFirstNameContaining("ramesh");
        System.out.println("students->" + students);
    }

    @Test
    public void findByGuardianNull(){
        List<Student> students=studentRepo.findByGuardianNull();
       students.forEach(student -> System.out.println(student ));
    }

    @Test
    public void  getStudentByEmailAddress(){
        Student student=studentRepo.getStudentByEmailAddress("adarsh1234@gmail.com");
        System.out.println(student);
    }
    @Test
    public void  getStudentByFirstNameEmailAddress(){
        String firstName=studentRepo.getStudentFirstNameByEmailAddress("adarsh1234@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student=studentRepo.getStudentByEmailAddressNative("adarsh1234@gmail.com");
        System.out.println(student);

    }
    @Test
    public void getStudentByGuardianName(){
        Student student=studentRepo.getStudentByGuardianName("g");
        System.out.println(student);
    }
    @Test
    public void updateStudentFirstNameByEmail(){
        studentRepo.updateStudentFirstNameByEmail("sachin","ramesh@gmail.com");
    }


}