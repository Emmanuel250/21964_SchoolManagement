/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.GeneralDao;
import java.util.List;
import model.Course;

/**
 *
 * @author emmanuel
 */
public class CourseServiceImpl implements CourseService {

    Course course = new Course();
    GeneralDao<Course> generalDao = new GeneralDao<Course>(Course.class);

    private boolean isValidCourse(String code) {
        if (generalDao.findBySTRING_PK(code) == null) {
            return false;
        }

        return true;
    }

    @Override
    public String registerCourse(Course c) {
        try {
            
            if (isValidCourse(c.getCode())) {
                throw new RuntimeException("Course already exist");
            }
            generalDao.create(c);
            return "Course created";
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String deleteCourse(String code) {
        try {
            
            if (!isValidCourse(code)) {
                throw new RuntimeException("Course does not exist");
            }
            
            course = generalDao.findBySTRING_PK(code);
            generalDao.delete(course);
            return "Course deleted";
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String UpdateCourse(Course c) {
        try {
            
            if (isValidCourse(c.getCode())) {
                throw new RuntimeException("Course already exist");
            }
            generalDao.update(c);
            return "Course updated";
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Course> listAllCourse() {
        return generalDao.listAll();
    }
}
