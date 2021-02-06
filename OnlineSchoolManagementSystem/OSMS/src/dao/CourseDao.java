/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Course;

/**
 *
 * @author emmanuel
 */
public interface CourseDao {
    public Course findByCourseCode(String code);
    public Course registerNewCourse(Course c);
    public Course updateCourse(Course c);
    public Course deleteCourse(String code);
}
