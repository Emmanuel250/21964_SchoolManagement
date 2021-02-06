/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Student;

/**
 *
 * @author emmanuel
 */
public interface StudentDao {
    public Student findByStudentId(String stId);
    public Student registerStudent(Student s);
    public Student updateStudent(Student s);
    public Student deleteStudent(String id);
}
