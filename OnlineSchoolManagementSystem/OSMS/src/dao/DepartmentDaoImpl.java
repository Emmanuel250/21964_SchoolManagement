/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class DepartmentDaoImpl implements DepartmentDao{

    Department department = new Department();
    @Override
    public Department registerNewDepartment(Department d) {
        Session session = Connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(d);
            transaction.commit();
            session.close();
            return d;
        } catch (Exception e) {
            return null;
        }
    }
    
}
