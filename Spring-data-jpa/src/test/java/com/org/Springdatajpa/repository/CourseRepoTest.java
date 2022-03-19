package com.org.Springdatajpa.repository;

import com.org.Springdatajpa.entity.Course;
import com.org.Springdatajpa.entity.CourseMaterial;
import com.org.Springdatajpa.entity.Student;
import com.org.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepo.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("mahindra")
                .lastName("singh")
                .build();
//        Course course1=Course.builder().title("JFS").credit(7).courseMaterial(CourseMaterial.builder().url("abc").build()).teacher(teacher).build();
//        courseRepo.save(course1);

    }

    @Test
    public void addCourse() {
        Course course = Course.
                builder()
                .title("c++")
                .credit(6)

                .build();
        courseRepo.save(course);
        Course course1 = Course.
                builder()
                .title("c#")
                .credit(6)
                .build();
        courseRepo.save(course1);
        Course course2 = Course.
                builder()
                .title("rubby")
                .credit(9)
                .build();
        courseRepo.save(course2);
        Course course3 = Course.
                builder()
                .title("Android")
                .credit(8)
                .build();
        courseRepo.save(course3);

    }

    @Test
    public void getCourseWithPagination() {
        Pageable pageable = PageRequest.of(0, 3);
        List<Course> courseList = courseRepo.findAll(pageable).getContent();
        int totalPages = courseRepo.findAll(pageable).getTotalPages();
        int size = courseRepo.findAll(pageable).getSize();
        System.out.println(size);
        System.out.println(totalPages);
        System.out.println(courseList);


    }

    @Test
    public void getCourseBySorting() {
        Pageable pageableSortByTiltle = PageRequest.of(0, 6, Sort.by("title"));
        List<Course> title = courseRepo.findAll(pageableSortByTiltle).getContent();
//    System.out.println(title);

        Pageable pageableByCredit = PageRequest.of(0, 6, Sort.by("credit").ascending());
        List<Course> credit = courseRepo.findAll(pageableByCredit).getContent();
//    System.out.println(credit);

        Pageable pageableByTitleCredit = PageRequest.of(0, 6, Sort.by("title").ascending().and(Sort.by("credit")));
        List<Course> titleCredit = courseRepo.findAll(pageableByTitleCredit).getContent();
        System.out.println(titleCredit);
    }

    @Test
    public void getAllCoursesContainingGivenTitle() {
        Pageable pageable = PageRequest.of(0, 6);
        List<Course> courses = courseRepo.findByTitleContaining("c", pageable).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourse() {
        List<Student> studentList = List.of(Student.builder().firstName("ramesh").lastName("s").emailId("ramesh@gmail.com").guardian(Guardian.builder().name("srini").phNo("12334").email("srini@gmail.com").build()).build(),
                Student.builder().firstName("sanjay").lastName("n").emailId("sanjay@gmail.com").guardian(Guardian.builder().name("mahi").phNo("123346").email("mahi@gmail.com").build()).build()
        );
        Course course = Course.
                builder()
                .title("DSA")
                .credit(8)
                .teacher(Teacher.builder().firstName("simons").lastName("N").build())
                .students(studentList)
                .build();
        courseRepo.save(course);
    }

}