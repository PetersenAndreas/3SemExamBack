/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "SignedUp.deleteAllRows", query = "DELETE FROM SignedUp"),
    @NamedQuery(name = "SignedUp.getAll", query = "SELECT s FROM SignedUp s")    
})
public class SignedUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean payed;
    
    @ManyToOne
    private YogaClass yogaclass;
    @ManyToOne
    private Student student;
    
    public SignedUp() {
    }

    public SignedUp(boolean payed) {
        this.payed = payed;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YogaClass getYogaclass() {
        return yogaclass;
    }

    public void setYogaclass(YogaClass yogaclass) {
        this.yogaclass = yogaclass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

 
}
