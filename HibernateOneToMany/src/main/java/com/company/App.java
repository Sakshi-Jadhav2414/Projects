package com.company;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.model.Course;
import com.company.model.ReportCard;
import com.company.model.Student;
import com.company.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        /*
            First Transaction
            Add Student + Courses + ReportCard
         */

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student1 = new Student("Sakshi");
        student1.addCourse(new Course("Java"));
        student1.addCourse(new Course("Hibernate"));

        ReportCard rc1 = new ReportCard(450);
        student1.setReportcard(rc1);
        session.persist(student1);

        tx.commit();

        System.out.println("\nFirst Transaction Completed");

        /*
            Second Transaction
         */

        Transaction tx1 = session.beginTransaction();
        Student student2 = new Student("Sahil");
        student2.addCourse(new Course("Spring Boot"));
        student2.addCourse(new Course("AI")
        );

        ReportCard rc2 = new ReportCard(420);
        student2.setReportcard(rc2);
        session.persist(student2);
        tx1.commit();

        System.out.println("\nSecond Transaction Completed");
        session.close();

        /*
            Fetching Data
         */

        Session getSession = HibernateUtil.getSessionFactory().openSession();

        /*
            First Student
         */

        Student stud1 = getSession.get(Student.class, student1.getId());
        System.out.println("\nStudent Details : " + stud1.getName());
        if (stud1.getReportcard() != null) {
            System.out.println("Marks : " + stud1.getReportcard().getMarks());
        }

        System.out.println("Courses Enrolled");

        stud1.getCourses().forEach(c -> System.out.println(c.getTitle()));

        /*
            Second Student
         */

        Student stud2 = getSession.get(Student.class, student2.getId());
        System.out.println("\nStudent Details : " + stud2.getName());
        if (stud2.getReportcard() != null) {
            System.out.println("Marks : " + stud2.getReportcard().getMarks());
        }

        System.out.println("Courses Enrolled");
        stud2.getCourses().forEach(c -> System.out.println(c.getTitle()));

        /*
            Bidirectional Example
            Course course = getSession.get(Course.class, 1L);
            System.out.println(course.getTitle());
            System.out.println(course.getStudent().getName());
         */

        getSession.close();
        HibernateUtil.close();
    }
}