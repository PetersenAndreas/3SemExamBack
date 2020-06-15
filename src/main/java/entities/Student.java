/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.SignedUpDTO;
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
    @NamedQuery(name = "Student.deleteAllRows", query = "DELETE FROM Student"),
    @NamedQuery(name = "Student.getAll", query = "SELECT s FROM Student s")    
})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    
    @OneToMany(mappedBy="student")
    List<SignedUp> signedUp = new ArrayList();
    
    public Student() {
    }

    public Student(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SignedUp> getSignedUp() {
        return signedUp;
    }
    
    public List<SignedUpDTO> getSignedUpDTO() {
        List<SignedUpDTO> suDTOList = new ArrayList(); 
        for(SignedUp su : signedUp) {
            SignedUpDTO suDTO = new SignedUpDTO(su);
        }
        return suDTOList;
    }

    public void setSignedUp(List<SignedUp> signedUp) {
        this.signedUp = signedUp;
    }

    
 
    
}
