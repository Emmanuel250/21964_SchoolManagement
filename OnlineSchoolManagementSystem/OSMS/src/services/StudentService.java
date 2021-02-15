/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.List;
import model.Student;

/**
 *
 * @author emmanuel
 */
public interface StudentService {
    public String registerStudent(Student s);
    public String deleteStudent(String id);
    public String UpdateStudent(Student s);
    public List<Student> listAllStudent();
}
