///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entities;
//
//import dto.YogaClassDTO;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//
///**
// *
// * @author andre
// */
//@Entity
//@NamedQueries({
//    @NamedQuery(name = "Instructor.deleteAllRows", query = "DELETE FROM Instructor"),
//    @NamedQuery(name = "Instructor.getAll", query = "SELECT i FROM Instructor i")    
//})
//public class Instructor implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    //@ManyToMany(mappedBy = "instructors")
//    @ManyToMany//(mappedBy = "instructors")
//    private List<YogaClass> yogaClasss = new ArrayList();
//    
//    public Instructor(String name, List<YogaClass> yogaClasss) {
//        this.yogaClasss = yogaClasss;
//        this.name = name;
//    }
//
//    public Instructor() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<YogaClass> getYogaClasss() {
//        return yogaClasss;
//    }
//    
//    public List<YogaClassDTO> getYogaClasssDTO() {
//        List<YogaClassDTO> yDTOList = new ArrayList(); 
////        for(YogaClass yc : yogaClasss) {
////            YogaClassDTO yDTO = new YogaClassDTO(yc);
////        }
//        System.out.println(this);
//        return yDTOList;
//    }
//
//    public void setYogaClasss(List<YogaClass> yogaClasss) {
//        this.yogaClasss = yogaClasss;
//    }
//    
//
// 
//}
