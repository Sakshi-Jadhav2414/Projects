package com.company.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*
        Unidirectional One-To-One Mapping
        Student ---> ReportCard
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reportcard_id")
    private ReportCard reportcard;

    /*
        Unidirectional One-To-Many Mapping
        One Student can enroll in many Courses
     */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Course> courses =
            new ArrayList<>();

    /*
        Bidirectional Example

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )

    private List<Course> courses =
            new ArrayList<>();
    */

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReportCard getReportcard() {
        return reportcard;
    }

    public void setReportcard(
            ReportCard reportcard
    ) {
        this.reportcard = reportcard;
    }

    public void addCourse(Course course) {
        courses.add(course);
        /*
            for bidirectional
            course.setStudent(this);
         */
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(
            List<Course> courses
    ) {

        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", reportcard=" + reportcard + "]";
    }
}