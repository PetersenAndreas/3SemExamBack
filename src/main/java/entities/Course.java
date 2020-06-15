/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.YogaClassDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author andre
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Course.deleteAllRows", query = "DELETE FROM Course"),
    @NamedQuery(name = "Course.getAll", query = "SELECT c FROM Course c")    
})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String description;
    
    @OneToMany(mappedBy="course")
    List<YogaClass> yogaClasss = new ArrayList();

    public Course() {
    }

    public Course(String courseName, String description, List<YogaClass> yogaClasss) {
        this.courseName = courseName;
        this.description = description;
        this.yogaClasss = yogaClasss;
    }
    
    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<YogaClass> getYogaClasss() {
        return yogaClasss;
    }
    
    public List<YogaClassDTO> getYogaClasssDTO() {
        List<YogaClassDTO> ycDTOList = new ArrayList(); 
        for(YogaClass yc : yogaClasss) {
            YogaClassDTO ycDTO = new YogaClassDTO(yc);
        }
        return ycDTOList;
    }

    public void setYogaClasss(List<YogaClass> yogaClasss) {
        this.yogaClasss = yogaClasss;
    }

}
