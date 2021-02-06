/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class CourseDaoImpl implements CourseDao{

    Course course = new Course();
    @Override
    public Course findByCourseCode(String code) {
        Session session = Connect.getSessionFactory().openSession();
        
        try {
            course = (Course)session.load(Course.class, code);
            return course;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Course registerNewCourse(Course c) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(c);
            transaction.commit();
            session.close();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Course updateCourse(Course c) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            course = (Course)session.load(Course.class, c.getCode());
            course.setName(c.getName());
            course.setCredit(c.getCredit());
            course.setDepartment(c.getDepartment());
            session.update(course);
            transaction.commit();
            session.close();
            return course;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Course deleteCourse(String code) {
        
        try {
            Session session = Connect.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            
            course = (Course)session.load(Course.class, code);
            session.delete(course);
            transaction.commit();
            
            return course;
        } catch (Exception e) {
            throw  new RuntimeException("Course does not Exist");
        }
    }
    
}
