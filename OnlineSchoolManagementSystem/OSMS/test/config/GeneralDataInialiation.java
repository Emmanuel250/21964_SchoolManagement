/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package config;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.time.LocalDate;

/**
 *
 * @author emmanuel
 */
public class GeneralDataInialiation {
    
    //        INITIALITIONS 
    
    public static Operation INSERT_FACULTs = 
            Operations.insertInto("Faculty")
            .columns("fcName")
            .values("IT")
            .values("EDUCATION")
            .values("THEOROGY")
            .values("BUSINESS")
            .build();
    
    public static Operation INSERT_DEPARTMENTs = 
            Operations.insertInto("Department")
            .columns("depName","fcName" )
            .values("SOFTWARE", "IT")
            .values("NEWTWORKING", "IT")
            .values("POLITICS", "EDUCATION")
            .values("LEADERSHIP", "EDUCATION")
            .values("NEW_TESTMENT", "THEOROGY")
            .values("MANAGEMENT", "BUSINESS")
            .build();
    
    public static Operation INSERT_COURSEs = 
            Operations.insertInto("Course")
            .columns("code", "name", "credit", "depName")
            .values("INSY 314", "JAVA", 4, "SOFTWARE")
            .values("INSY 315", "PL/SQL", 4, "SOFTWARE")
            .values("INSY 316", "TCP/IP", 3, "NEWTWORKING")
            .values("INSY 317", "STATISTICS", 3, "MANAGEMENT")
            .values("INSY 318", "SPEECH", 4, "POLITICS")
            .values("INSY 319", "CYCOLOGY", 4, "LEADERSHIP")
            .values("INSY 400", "GEOGRAPHY", 2, "LEADERSHIP")       
            .build();
    
    public static Operation INSERT_STUDENTs = 
            Operations.insertInto("Student")
            .columns("studentId", "name", "gender", "dateOfBirth","phoneNumber", "email","depName")
            .values("1001", "Emmanuel", "MALE", LocalDate.now(), "0788596281", "primary@gmail.com", "NEWTWORKING")
            .values("1002", "NTIVUGURUZWA", "MALE", LocalDate.now(), "0788596281", "ntivugu@gmail.com", "SOFTWARE")
            .values("1003", "KEILA Audrey", "FEMALE", LocalDate.now(), "07883230874", "keillaodrey@gmail.com", "LEADERSHIP")
            .build();
            
    public static Operation INSERT_STUDENT_COURSE = 
            Operations.insertInto("Student_Course")
            .columns("students_studentId", "courses_code")
            .values("1002", "INSY 317")
            .build();
    //       DELETE
    
    public static Operation DELETE_ALL_FACULTY = 
            Operations.deleteAllFrom("Faculty");
    public static Operation DELETE_ALL_DEPARTMENTs = 
            Operations.deleteAllFrom("Department");
    public static Operation DELETE_ALL_COURSEs = 
            Operations.deleteAllFrom("Course");
    public  static  Operation DELETE_ALL_STUDENTs = 
            Operations.deleteAllFrom("Student");
    public static Operation DELETE_ALL_STUDENT_COURSE = 
            Operations.deleteAllFrom("Student_Course");
}
