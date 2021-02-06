/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class StudentDaoImpl implements StudentDao {

    Student student = new Student();

    @Override
    public Student findByStudentId(String stId) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            student = (Student) session.load(Student.class, stId);
            return student;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Student registerStudent(Student s) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            session.save(s);
            transaction.commit();
            session.close();
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Student updateStudent(Student s) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {        
            session.update(s);
            transaction.commit();
            session.close();
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Student deleteStudent(String id) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {  
            
            Student st = (Student)session.load(Student.class, id);
            session.delete(st);
            transaction.commit();
            
            return st;
        } catch (Exception e) {
            return null;
        }
    }

    
}
