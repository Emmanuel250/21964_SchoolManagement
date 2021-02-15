/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class GeneralDaoTest extends AbstractTest {

    private Department department = new Department();
    Course course = new Course();
    GeneralDao<Course> generalDao = new GeneralDao<>(Course.class);

    public GeneralDaoTest() {
    }

    @Test
    public void testCreate() {
        department.setDepName("SOFTWARE");
        course = new Course("INSY 111", "TEST INSERT", 3, department);

        Course returnedCourse = generalDao.create(course);
        Assert.assertEquals(returnedCourse.getDepartment().getDepName(), "SOFTWARE");
    }

    @Test
    public void testUpdate() {
        department.setDepName("POLITICS");
        course = new Course("INSY 314", "TEST UPDATE", 4, department);

        Course returnedCourse = generalDao.update(course);
        Assert.assertEquals(returnedCourse.getDepartment().getDepName(), "POLITICS");
    }

    @Test
    public void testDelete() {
        department.setDepName("POLITICS");
        course = new Course("INSY 314", "TEST UPDATE", 4, department);

        boolean message  = generalDao.delete(course);
        Assert.assertEquals(message, true);

    }

    @Test
    public void testFindBySTRING_PK() {
        course = generalDao.findBySTRING_PK("INSY 314");
        Assert.assertEquals(course.getCode(), "INSY 314");
    }

    @Test
    public void testListAll() {

        List<Course> courses = generalDao.listAll();

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
