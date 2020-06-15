/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.SignedUp;
import entities.Student;
import entities.YogaClass;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class StudentDTO {
    
    private long id;
    private String name;
    private String phone;
    private String email;
    List<SignedUpDTO> signedUp;

    public StudentDTO() {
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.phone = student.getPhone();
        this.email = student.getEmail();
        this.signedUp = student.getSignedUpDTO();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
//    public static List<StudentDTO> convertStudentListToStudentListDTO(List<Student> students){
//        List<StudentDTO> studentsDTO = new ArrayList<>();
//        for (Student student : students) {
//            studentsDTO.add(new StudentDTO(student));
//        }
//        return studentsDTO;
//    } 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SignedUpDTO> getSignedUp() {
        return signedUp;
    }

    public void setSignedUp(List<SignedUpDTO> signedUp) {
        this.signedUp = signedUp;
    }
    
}
