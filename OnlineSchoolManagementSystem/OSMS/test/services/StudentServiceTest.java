/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import config.AbstractTest;
import config.GeneralDataInialiation;
import java.time.LocalDate;
import model.Department;
import model.Gender;
import model.Student;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class StudentServiceTest extends AbstractTest{
    
    
    private Department department = new Department();
    Student student = new Student();
    StudentService studentService = new StudentServiceImpl();
    
    public StudentServiceTest() {
    }

    
    @Test(expectedExceptions = {RuntimeException.class})
    public void testRegisterExistingStudent() {
        department.setDepName("SOFTWARE");
        student = new Student("9000", "Emmanuel", Gender.MALE, LocalDate.now(),"07888888", "djnti@gmail.com", department);
        
        studentService.registerStudent(student);    
    }
    
    @Test
    public void testRegisterStudent() {
        department.setDepName("SOFTWARE");
        student = new Student("9000", "Emmanuel", Gender.MALE, LocalDate.now(),"07888888", "djnti@gmail.com", department);
        
        String message = studentService.registerStudent(student);
        Assert.assertEquals(message, "Student saved");
    }
    
    @Test(expectedExceptions = {RuntimeException.class})
    public void testDeleteUnExistingStudent() {
        studentService.deleteStudent("10");
    }
    
    
    @Test
    public void testDeleteStudent() {
        String message = studentService.deleteStudent("1002");
        Assert.assertEquals(message, "Student deleted");
    }

    @Test
    public void testUpdateStudent() {
        department.setDepName("SOFTWARE");
        student = new Student("1001", "Emmanuel", Gender.FEMALE, LocalDate.now(),"07888888", "djnti@gmail.com", department);
        
        String message = studentService.UpdateStudent(student);
        Assert.assertEquals(message, "Student updated");
    }

    @Test
    public void testListAllStudent() {
        Assert.assertEquals(studentService.listAllStudent().size(), 3);
    }
    
    @BeforeMethod
    public void initialiseAllData() {
        excute(GeneralDataInialiation.INSERT_FACULTs);
        excute(GeneralDataInialiation.INSERT_DEPARTMENTs);
        excute(GeneralDataInialiation.INSERT_STUDENTs);
        excute(GeneralDataInialiation.INSERT_COURSEs);
        excute(GeneralDataInialiation.INSERT_STUDENT_COURSE);

    }

    @AfterMethod
    public void deleteAllData() {
        excute(GeneralDataInialiation.DELETE_ALL_STUDENT_COURSE);
        excute(GeneralDataInialiation.DELETE_ALL_STUDENTs);
        excute(GeneralDataInialiation.DELETE_ALL_COURSEs);
        excute(GeneralDataInialiation.DELETE_ALL_DEPARTMENTs);
        excute(GeneralDataInialiation.DELETE_ALL_FACULTY);
    }

    @BeforeTest
    public void createDatabase() {
        Connect.getSessionFactory();
    }
}
