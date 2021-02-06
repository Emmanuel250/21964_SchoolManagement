/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Course;
import model.Faculty;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class FacultyDaoImpl implements FacultyDao{

    Faculty faculty = new Faculty();

    @Override
    public Faculty registerNewFaculty(Faculty f) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(f);
            transaction.commit();
            session.close();
            return f;
        } catch (Exception e) {
            return null;
        }
    }    
}
