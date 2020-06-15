/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Course;
import entities.YogaClass;
import java.util.List;

/**
 *
 * @author andre
 */
public class CourseDTO {
    
    private long id;
    private String courseName;
    private String description;
    List<YogaClassDTO> yogaClasss;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
        this.yogaClasss = course.getYogaClasssDTO();
    }
    
    public CourseDTO() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<YogaClassDTO> getYogaClasss() {
        return yogaClasss;
    }

    public void setYogaClasss(List<YogaClassDTO> yogaClasss) {
        this.yogaClasss = yogaClasss;
    }

}
