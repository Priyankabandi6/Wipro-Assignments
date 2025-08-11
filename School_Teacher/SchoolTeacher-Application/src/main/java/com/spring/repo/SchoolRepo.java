package com.spring.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {

    List<School> findBySchoolName(String schoolName);

    List<School> findByTeacher_TeacherName(String teacherName);
  
}