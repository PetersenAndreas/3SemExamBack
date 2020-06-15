///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dto;
//
////import entities.Instructor;
//import entities.YogaClass;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author andre
// */
//public class InstructorDTO {
//    
//    private long id;
//    private String name;
//    private List<YogaClassDTO> yogaClasss;
//
//    public InstructorDTO(Instructor instructor) {
//        this.id = instructor.getId();
//        this.name = instructor.getName();
//        this.yogaClasss = instructor.getYogaClasssDTO();
//    }
//
//    public InstructorDTO() {
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
////    public static List<InstructorDTO> convertInstructorListToInstructorListDTO(List<Instructor> instructors){
////        List<InstructorDTO> instructorsDTO = new ArrayList<>();
////        for (Instructor instructor : instructors) {
////            instructorsDTO.add(new InstructorDTO(instructor));
////        }
////        return instructorsDTO;
////    }
//
//    public List<YogaClassDTO> getYogaClasss() {
//        return yogaClasss;
//    }
//    
////    public List<YogaClassDTO> getYogaClasssDTO() {
////        List<YogaClassDTO> iDTOList = new ArrayList(); 
////        for(Instructor i : instructors) {
////            InstructorDTO iDTO = new InstructorDTO(i);
////        }
////        return iDTOList;
////    }
//
//    public void setYogaClasss(List<YogaClassDTO> yogaClasss) {
//        this.yogaClasss = yogaClasss;
//    }
//    
//}
