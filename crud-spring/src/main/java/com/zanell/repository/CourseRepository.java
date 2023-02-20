package com.zanell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zanell.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {

}
