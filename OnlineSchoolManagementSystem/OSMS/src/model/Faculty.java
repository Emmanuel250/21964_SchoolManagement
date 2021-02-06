/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author emmanuel
 */
@Entity
public class Faculty {
    @Id
    private String fcName;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;
    
    public Faculty() {
    }

    public Faculty(String fcName) {
        this.fcName = fcName;
    }

    public String getFcName() {
        return fcName;
    }

    public void setFcName(String fcName) {
        this.fcName = fcName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
