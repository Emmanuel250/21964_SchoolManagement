/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import config.AbstractTest;
import config.GeneralDataInialiation;
import java.time.LocalDate;
import model.Department;
import model.Gender;
import model.Student;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author emmanuel
 */
public class StudentDaoTest extends AbstractTest{
    
    Student student = new Student();
    Department department = new Department();
    StudentDao studentDao = new StudentDaoImpl();
    
    public StudentDaoTest() {
    }

    @Test
    public void testFindByStudentId() {
        
    }

    @Test
    public void testRegisterStudent() {
        department.setDepName("SOFTWARE");
        student = new Student("9000", "Emmanuel", Gender.MALE, LocalDate.now(), "07888888", "djnti@gmail.com", department);
        
        Student registeredStudent = studentDao.registerStudent(student);
        
        Assert.assertEquals(registeredStudent.getName(), "Emmanuel");
    }

    @Test
    public void testUpdateStudentInfo() {
        department.setDepName("SOFTWARE");
        student = new Student("1001", "RUKUNDO", Gender.MALE, LocalDate.now(), "07888888", "djnti@gmail.com", department);
        
        Student registeredStudent = studentDao.updateStudent(student);
        
        Assert.assertEquals(registeredStudent.getName(), "RUKUNDO");
    }

    @Test
    public void testDeleteStudent() {
//        Student st = studentDao.deleteStudent("1003");
//        Assert.assertEquals(st.getStudentId(), "1003");
    }

    @Test
    public void testListAllStudent() {
    }
    
    
    @BeforeMethod
    public void initialiseAllData(){
        excute(GeneralDataInialiation.INSERT_FACULTs);
        excute(GeneralDataInialiation.INSERT_DEPARTMENTs);
        excute(GeneralDataInialiation.INSERT_STUDENTs);
        excute(GeneralDataInialiation.INSERT_COURSEs);
        excute(GeneralDataInialiation.INSERT_STUDENT_COURSE);
    }
    
    @AfterMethod
    public void deleteAllData(){
        excute(GeneralDataInialiation.DELETE_ALL_STUDENT_COURSE);
        excute(GeneralDataInialiation.DELETE_ALL_STUDENTs);
        excute(GeneralDataInialiation.DELETE_ALL_COURSEs);
        excute(GeneralDataInialiation.DELETE_ALL_DEPARTMENTs);
        excute(GeneralDataInialiation.DELETE_ALL_FACULTY);
    }
}
