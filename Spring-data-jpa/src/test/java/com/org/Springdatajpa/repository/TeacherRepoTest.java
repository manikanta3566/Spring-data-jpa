package com.org.Springdatajpa.repository;

import com.org.Springdatajpa.entity.Course;
import com.org.Springdatajpa.entity.CourseMaterial;
import com.org.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private TeacherRepo teacherRepo;
//    public List<Course> addCourses(){
//        Course course1=Course.builder().title("JFS").credit(7).courseMaterial(CourseMaterial.builder().url("abc").build()).build();
//        Course course2=Course.builder().title("PFS").credit(6).courseMaterial(CourseMaterial.builder().url("ybc").build()).build();
//        List<Course> courses=List.of(course1,course2);
//        return courses;
//}
    @Test
    public void  saveTeacher(){
//        List<Course> courses = addCourses();
//        Teacher teacher=new Teacher("sonali","singh",courses);
//        teacherRepo.save(teacher);




    }
}