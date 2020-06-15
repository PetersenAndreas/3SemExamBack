package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class SetupDummies {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Sem3Exam",
            "dev",
            "ax2",
            EMF_Creator.Strategy.DROP_AND_CREATE);

    public static void main(String[] args) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            //em.createNamedQuery("Instructor.deleteAllRows").executeUpdate();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();
            em.createNamedQuery("SignedUp.deleteAllRows").executeUpdate();
            em.createNamedQuery("Student.deleteAllRows").executeUpdate();
            em.createNamedQuery("YogaClass.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
          addEntities();
    }

    private static void addEntities() {
        EntityManager em = EMF.createEntityManager();
        List<YogaClass> yoga1 = new ArrayList();
        //List<Instructor> instructors1 = new ArrayList();
        try {
            em.getTransaction().begin();
            
            YogaClass yc1 = new YogaClass(12, 50);
            yoga1.add(yc1);
            
            //Instructor instructor1 = new Instructor("Kim", yoga1);
            //instructors1.add(instructor1);
            
            //yc1.setInstructors(instructors1);
            
            Course course1 = new Course("Hot yoga", "It is hot", yoga1);
            Course course2 = new Course("Normal yoga", "It is normal", yoga1);
            yc1.setCourse(course2);
            
            SignedUp signedUp1 = new SignedUp();
            
            Student student1 = new Student("Hans Hansen", "12345678", "hans@gamail.com");
            
            signedUp1.setPayed(false);
            signedUp1.setYogaclass(yc1);
            signedUp1.setStudent(student1);
            
            em.persist(yc1);
            em.persist(course1);
            em.persist(course2);
            em.persist(signedUp1);
            //em.persist(instructor1);
            em.persist(student1);
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}