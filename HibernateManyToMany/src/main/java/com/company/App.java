package com.company;

import com.company.model.Course;
import com.company.model.Student;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        // Courses
        Course course1 = new Course("Java");
        Course course2 = new Course("Spring Boot");
        Course course3 = new Course("Hibernate");

        // Students
        Student student1 = new Student("Vishal");
        Student student2 = new Student("Rahul");

        // Add Courses
        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course2);
        student2.addCourse(course3);

        // Save Students
        session.persist(student1);
        session.persist(student2);

        tx.commit();
        System.out.println("\nMany To Many Mapping Saved Successfully");

        // Fetch Student
        Student fetchedStudent = session.get(Student.class, 1L);
        System.out.println("\nStudent Details");
        System.out.println(fetchedStudent);
        System.out.println("\nCourse Details");
        for (Course course :
                fetchedStudent.getCourses()) {
            System.out.println(course);
        }
        session.close();
        HibernateUtil.close();
    }
}