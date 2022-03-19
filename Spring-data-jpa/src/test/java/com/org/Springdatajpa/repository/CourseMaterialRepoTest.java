package com.org.Springdatajpa.repository;

import com.org.Springdatajpa.entity.Course;
import com.org.Springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {
    @Autowired
    private CourseMaterialRepo repo;

//    @Test
//    public void saveCourseMaterial() {
//        Course course = Course.builder()
//                .title("Spring framework")
//                .credit(8)
//                .build();
//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("www.google.com")
//                .course(course)
//                .build();
//        repo.save(courseMaterial);
//
//
//    }
    @Test
    public void getAllCourseMaterial(){
        List<CourseMaterial> courseMaterial=repo.findAll();
        System.out.println("course info->"+courseMaterial);
    }

    @Test
    public  void  saveCourseMaterial(){
        repo.save(CourseMaterial.builder().url("www.dsa.com").build());
    }
}