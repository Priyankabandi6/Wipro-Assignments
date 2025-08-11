package com.spring.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Teacher findByTeacherName(String teachername);
}

