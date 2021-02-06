/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import config.AbstractTest;
import config.GeneralDataInialiation;
import model.Department;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author emmanuel
 */
public class DepartmentDaoTest extends AbstractTest{
    
    public DepartmentDaoTest() {
    }

    @Test
    public void testRegisterNewDepartment() {
        Department department = new Department("NEW_DEPT");
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        Department depart = departmentDao.registerNewDepartment(department);
        Assert.assertEquals(depart.getDepName(), "NEW_DEPT");
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
