/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import config.AbstractTest;
import config.GeneralDataInialiation;
import model.Faculty;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.Connect;

/**
 *
 * @author emmanuel
 */
public class FacultyDaoTest  extends AbstractTest{
    
    Faculty faculty = new Faculty();
    FacultyDao facultyDao = new FacultyDaoImpl();
    
    public FacultyDaoTest() {
    }


    @Test
    public void testRegisterNewFaculty() {
        
        faculty = new Faculty("TEST_REG_FUC");
        Faculty returnFaculty = facultyDao.registerNewFaculty(faculty);
        Assert.assertEquals(returnFaculty.getFcName(), "TEST_REG_FUC");
        
    }
    
    @BeforeMethod
    public void initialiseAllData(){
        excute(GeneralDataInialiation.INSERT_FACULTs);
        
    }
    
    @AfterMethod
    public void deleteAllData(){
        excute(GeneralDataInialiation.DELETE_ALL_FACULTY);
    }
    
    @Test
    public void initialiseDatabaseTable(){
        Connect.getSessionFactory();
    }
}
