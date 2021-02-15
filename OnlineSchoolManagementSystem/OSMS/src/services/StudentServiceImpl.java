/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.GeneralDao;
import java.util.List;
import model.Student;

/**
 *
 * @author emmanuel
 */
public class StudentServiceImpl implements StudentService {

    Student student = new Student();
    GeneralDao<Student> studentDao = new GeneralDao<Student>(Student.class);

    private boolean isValidStudent(String id) {
        if (studentDao.findBySTRING_PK(id) == null) {
            return false;
        }
        return true;
    }

    @Override
    public String registerStudent(Student s) {

        try {
            if (isValidStudent(s.getStudentId())) {
                throw new RuntimeException("Student already exist");
            }
            
            studentDao.create(s);
            return "Student saved";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteStudent(String id) {
        try {
            
            if (!isValidStudent(id)) {
                throw new RuntimeException("Student does not exist");
            }
            
            student = studentDao.findBySTRING_PK(id);
            studentDao.delete(student);
            return "Student deleted";
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String UpdateStudent(Student s) {
        try {
            
            if (!isValidStudent(s.getStudentId())) {
                throw new RuntimeException("Student does not exist");
            }
            studentDao.update(s);
            return "Student updated";
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Student> listAllStudent() {
        return studentDao.listAll();
    }

}
