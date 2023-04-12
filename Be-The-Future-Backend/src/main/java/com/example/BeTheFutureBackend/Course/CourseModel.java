package com.example.BeTheFutureBackend.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseModel {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseModel(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        if (courseRepository.existsById(course.getCourseId())) {
            throw new IllegalStateException("course already exists");
        }
        return courseRepository.save(course);
    }

    public Course getCourse(String courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public int voteToApproveCourse(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        course.setNumberOfVotes(course.getNumberOfVotes() + 1);
        course.setNumberOfApproved(course.getNumberOfApproved() + 1);
        courseRepository.save(course);

        return course.getNumberOfApproved();
    }

    public int voteToDisapproveCourse(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        course.setNumberOfVotes(course.getNumberOfVotes() + 1);
        course.setNumberOfDisapproved(course.getNumberOfDisapproved() + 1);
        courseRepository.save(course);

        return course.getNumberOfDisapproved();
    }

    /*
        public boolean approveCourse(String courseId) {
            Course course = courseRepository.findByCourseId(courseId);
            if (course.getNumberOfApproved() >= 0.8 * course.getNumberOfVotes()) {
                course.setApproved(true);
                courseRepository.save(course);
                return true;
            }
            return false;
        }
    */
    public String approveCourse(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course.getNumberOfApproved() >= 0.8 * course.getNumberOfVotes()) {
            course.setApproved(true);
            courseRepository.save(course);
            return "Course approved";
        }
        return "course not approved";
    }
/*
    public boolean disapproveCourse(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course.getNumberOfApproved() <= 0.8 * course.getNumberOfVotes()) {
            course.setApproved(false);
            courseRepository.save(course);
            return false;
        }
        return true;
    }
*/
}
