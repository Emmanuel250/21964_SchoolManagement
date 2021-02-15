/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import config.AbstractTest;
import config.GeneralDataInialiation;
import java.util.List;
import model.Course;
import model.Department;
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
public class CourseServiceTest extends AbstractTest {

    CourseServiceImpl courseService = new CourseServiceImpl();
    private Department department = new Department();
    Course course = new Course();

    public CourseServiceTest() {
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testRegisterExistingCourse() {
        department.setDepName("SOFTWARE");
        course = new Course("INSY 312", "TEST INSERT", 3, department);
        courseService.registerCourse(course);
    }
    
    @Test
    public void testRegisterCourse() {
        department.setDepName("SOFTWARE");
        course = new Course("INSY 111", "TEST INSERT", 3, department);

        String message = courseService.registerCourse(course);
        Assert.assertEquals(message, "Course created");
    }

    
    @Test(expectedExceptions = {RuntimeException.class})
    public void testDeleteUnExistingCourse() {
        courseService.deleteCourse("INSY 3143");
    }
    
    
    @Test
    public void testDeleteCourse() {
        String message = courseService.deleteCourse("INSY 314");
        Assert.assertEquals(message, "Course deleted");
    }

    
    @Test
    public void testUpdateUnExistingCourse() {
        department.setDepName("POLITICS");
        course = new Course("INSY 1111", "TEST UPDATE", 4, department);
        courseService.UpdateCourse(course);
    }
    
    
    @Test
    public void testUpdateCourse() {
        department.setDepName("POLITICS");
        course = new Course("INSY 111", "TEST UPDATE", 4, department);

        String message = courseService.UpdateCourse(course);
        Assert.assertEquals(message, "Course updated");
    }

    @Test
    public void testListAllCourse() {
        List<Course> courses = courseService.listAllCourse();
        
        Assert.assertEquals(courses.size(), 7);
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
