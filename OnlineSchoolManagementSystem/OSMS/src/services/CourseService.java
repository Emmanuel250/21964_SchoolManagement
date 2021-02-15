/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.List;
import model.Course;

/**
 *
 * @author emmanuel
 */
public interface CourseService {
    
    public String registerCourse(Course c);
    public String deleteCourse(String code);
    public String UpdateCourse(Course c);
    public List<Course> listAllCourse();
}
