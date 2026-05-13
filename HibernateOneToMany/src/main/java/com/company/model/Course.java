package com.company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    /*
        Bidirectional Example

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    */

    public Course() {}

    public Course(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
        Bidirectional Example

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    */

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }
}