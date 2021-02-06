/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import config.AbstractTest;
import config.GeneralDataInialiation;
import model.Course;
import model.Department;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author emmanuel
 */
public class CourseDaoTest extends AbstractTest{
    
    Course course = new Course();
    private Department department = new Department();
    CourseDao courseDao = new CourseDaoImpl();
    
    public CourseDaoTest() {
    }

    @Test
    public void testFindByCourseCode() {
        course = courseDao.findByCourseCode("INSY 400");
        Assert.assertEquals(course.getDepartment().getDepName(), "LEADERSHIP");
    }

    @Test
    public void testRegisterNewCourse() {
        department.setDepName("SOFTWARE");
        course = new Course("INSY 1000", "TEST_NEW_COURSE", 8, department);
        Course registerdCourse = courseDao.registerNewCourse(course);
        Assert.assertEquals(course.getCode(), "INSY 1000");
    }

    @Test
    public void testUpdateCourse() {
        department.setDepName("POLITICS");
        course = new Course("INSY 400", "TEST_UPDATE_COURSE", 8, department);
        Course registerdCourse = courseDao.updateCourse(course);
        Assert.assertEquals(course.getCode(), "INSY 400");
    }

    @Test
    public void testDeleteCourse() {
        Course deletedCourse = courseDao.deleteCourse("INSY 400");
        Assert.assertEquals(deletedCourse.getCode(), "INSY 400");
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
