package com.example.BeTheFutureBackend.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    Course findByCourseId(String courseId);


}
