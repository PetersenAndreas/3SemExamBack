/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

//import dto.InstructorDTO;
import dto.SignedUpDTO;
import dto.YogaClassDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author andre
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "YogaClass.deleteAllRows", query = "DELETE FROM YogaClass"),
    @NamedQuery(name = "YogaClass.getAll", query = "SELECT y FROM YogaClass y")    
})
public class YogaClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int maxParticipants;
    private int price;
    
//    @ManyToMany
//    List<Instructor> instructors = new ArrayList();
    
    @ManyToOne
    private Course course;
    
    @OneToMany(mappedBy="yogaclass")
    List<SignedUp> signedUp = new ArrayList();
//    @ManyToMany(mappedBy = "yogaClass")
//    private List<Instructor> instructors;

    public YogaClass(int maxParticipants, int price) {
        this.maxParticipants = maxParticipants;
        this.price = price;
    }

    public YogaClass() {
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Instructor> getInstructors() {
//        return instructors;
//    }
//    
//    public List<InstructorDTO> getInstructorsDTO() {
//        List<InstructorDTO> iDTOList = new ArrayList(); 
//        for(Instructor i : instructors) {
//            InstructorDTO iDTO = new InstructorDTO(i);
//        }
//        return iDTOList;
//    }
//
//    public void setInstructors(List<Instructor> instructors) {
//        this.instructors = instructors;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<SignedUp> getSignedUp() {
        return signedUp;
    }
    
    public List<SignedUpDTO> getSignedUpDTO() {
        List<SignedUpDTO> suDTOList = new ArrayList(); 
        for(SignedUp s : signedUp) {
            SignedUpDTO sDTO = new SignedUpDTO(s);
            
        }
        return suDTOList;
    }

    public void setSignedUp(List<SignedUp> signedUp) {
        this.signedUp = signedUp;
    }
    
    

    
}
