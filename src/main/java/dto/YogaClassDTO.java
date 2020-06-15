/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Course;
//import entities.Instructor;
import entities.SignedUp;
import entities.YogaClass;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class YogaClassDTO {
    
    private long id;
    private int maxParticipants;
    private int price;
    //List<InstructorDTO> instructors;
    //List<SignedUpDTO> signedUp;

    public YogaClassDTO() {
    }

    public YogaClassDTO(YogaClass yogaClass) {
        this.id = yogaClass.getId();
        this.maxParticipants = yogaClass.getMaxParticipants();
        this.price = yogaClass.getPrice();
        //this.instructors = yogaClass.getInstructorsDTO();
        //this.signedUp = yogaClass.getSignedUpDTO();
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public List<InstructorDTO> getInstructors() {
//        return instructors;
//    }
//    
//    public void setInstructors(List<InstructorDTO> instructors) {
//        this.instructors = instructors;
//    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
    
//    public static List<YogaClassDTO> convertYogaListToYogaListDTO(List<YogaClass> yogaClasss){
//        List<YogaClassDTO> yogaClasssDTO = new ArrayList<>();
//        for (YogaClass yogaClass : yogaClasss) {
//            yogaClasssDTO.add(new YogaClassDTO(yogaClass));
//        }
//        return yogaClasssDTO;
//    } 

//    public List<SignedUpDTO> getSignedUp() {
//        return signedUp;
//    }
//
//    public void setSignedUp(List<SignedUpDTO> signedUp) {
//        this.signedUp = signedUp;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
}
