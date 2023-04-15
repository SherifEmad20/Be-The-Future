package com.example.BeTheFutureBackend.Course;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")

public class Course {

    @Id
    String courseId;
    String courseName;
    int numberOfVotes = 0;

    boolean isApproved = false;

    int numberOfApproved = 0;

    int numberOfDisapproved = 0;

    String photo;


    public Course() {
    }

    public Course(String courseId, String courseName, int numberOfVotes, boolean isApproved, int numberOfApproved,
                  int numberOfDisapproved, String photo) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfVotes = numberOfVotes;
        this.isApproved = isApproved;
        this.numberOfApproved = numberOfApproved;
        this.numberOfDisapproved = numberOfDisapproved;
        this.photo = photo;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getNumberOfApproved() {
        return numberOfApproved;
    }

    public void setNumberOfApproved(int numberOfApproved) {
        this.numberOfApproved = numberOfApproved;
    }

    public int getNumberOfDisapproved() {
        return numberOfDisapproved;
    }

    public void setNumberOfDisapproved(int numberOfDisapproved) {
        this.numberOfDisapproved = numberOfDisapproved;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
