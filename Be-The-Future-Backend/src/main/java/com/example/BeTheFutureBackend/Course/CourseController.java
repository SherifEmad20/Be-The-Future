package com.example.BeTheFutureBackend.Course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseModel courseModel;

    @Autowired
    public CourseController(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        return courseModel.addCourse(course);
    }

    @GetMapping("/getCourse/{courseId}")
    public Course getCourse(@PathVariable("courseId") String courseId) {
        return courseModel.getCourse(courseId);
    }

    @GetMapping("/getAllCourses")
    public Iterable<Course> getAllCourses() {
        return courseModel.getAllCourses();
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public void deleteCourse(@PathVariable("courseId") String courseId) {
        courseModel.deleteCourse(courseId);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) {
        return courseModel.updateCourse(course);
    }

    @PutMapping("/voteToApproveCourse/{courseId}")
    public int voteToApproveCourse(@PathVariable("courseId") String courseId) {
        return courseModel.voteToApproveCourse(courseId);
    }

    @PutMapping("/voteToDisapproveCourse/{courseId}")
    public int voteToDisapproveCourse(@PathVariable("courseId") String courseId) {
        return courseModel.voteToDisapproveCourse(courseId);
    }

    /*
        @PutMapping("/approveCourse")
        public boolean approveCourse(String courseId) {
            return courseModel.approveCourse(courseId);
        }
    */
    @PutMapping("/approveCourse/{courseId}")
    public String approveCourse(@PathVariable("courseId") String courseId) {
        return courseModel.approveCourse(courseId);
    }
/*
    @PutMapping("/disapproveCourse")
    public boolean disapproveCourse(String courseId) {
        return courseModel.disapproveCourse(courseId);
    }*/
}
