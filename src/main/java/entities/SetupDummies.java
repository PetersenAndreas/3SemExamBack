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
        List<YogaClass> yoga2 = new ArrayList();
        List<YogaClass> yoga3 = new ArrayList();
        List<YogaClass> yoga4 = new ArrayList();
        List<YogaClass> yoga5 = new ArrayList();
        List<YogaClass> yoga6 = new ArrayList();
        List<YogaClass> yoga7 = new ArrayList();
        List<YogaClass> yoga8 = new ArrayList();
        List<YogaClass> yoga9 = new ArrayList();
        //List<Instructor> instructors1 = new ArrayList();
        try {
            em.getTransaction().begin();
            
            YogaClass yc1 = new YogaClass(12, 50);
            YogaClass yc2 = new YogaClass(20, 49);
            YogaClass yc3 = new YogaClass(25, 80);
            YogaClass yc4 = new YogaClass(10, 150);
            YogaClass yc5 = new YogaClass(10, 50);
            YogaClass yc6 = new YogaClass(5, 500);
            YogaClass yc7 = new YogaClass(12, 120);
            YogaClass yc8 = new YogaClass(25, 49);
            YogaClass yc9 = new YogaClass(20, 49);
            yoga1.add(yc1);
            yoga2.add(yc2);
            yoga3.add(yc3);
            yoga4.add(yc4);
            yoga5.add(yc5);
            yoga6.add(yc6);
            yoga7.add(yc1);
            yoga8.add(yc8);
            yoga9.add(yc9);
            
            //Instructor instructor1 = new Instructor("Kim", yoga1);
            //instructors1.add(instructor1);
            
            //yc1.setInstructors(instructors1);
            
            Course course1 = new Course("Hot yoga", "It is hot", yoga1);
            Course course2 = new Course("Normal yoga", "It is normal", yoga1);
            Course course3 = new Course("Power yoga", "For powerfull people", yoga2);
            Course course4 = new Course("Vinyasa yoga", "For the active", yoga3);
            Course course5 = new Course("Hatha yoga", "The favorite", yoga4);
            Course course6 = new Course("Prenatal yoga", "Relaxation", yoga5);
            Course course7 = new Course("Aerial yoga", "Feel like a baby afterwards", yoga6);
            Course course8 = new Course("Kundalini yoga", "Feel the mindfullness", yoga7);
            
            yc1.setCourse(course2);
            yc2.setCourse(course1);
            yc3.setCourse(course3);
            yc4.setCourse(course4);
            yc5.setCourse(course5);
            yc6.setCourse(course6);
            yc7.setCourse(course7);
            yc8.setCourse(course8);
            yc9.setCourse(course8);
            
            SignedUp signedUp1 = new SignedUp();
            SignedUp signedUp2 = new SignedUp();
            SignedUp signedUp3 = new SignedUp();
            SignedUp signedUp4 = new SignedUp();
            SignedUp signedUp5 = new SignedUp();
            SignedUp signedUp6 = new SignedUp();
            SignedUp signedUp7 = new SignedUp();
//            SignedUp signedUp8 = new SignedUp();
//            SignedUp signedUp9 = new SignedUp();
            
            Student student1 = new Student("Hans Hansen", "12345678", "hans@gamail.com");
            signedUp1.setPayed(false);
            signedUp1.setYogaclass(yc1);
            signedUp1.setStudent(student1);
            Student student2 = new Student("Mikkel Hansen", "87654321", "mikkel@gamail.com");
            signedUp2.setPayed(true);
            signedUp2.setYogaclass(yc1);
            signedUp2.setStudent(student2);
            Student student3 = new Student("Bo Larsen", "98765432", "bo@gamail.com");
            signedUp3.setPayed(true);
            signedUp3.setYogaclass(yc2);
            signedUp3.setStudent(student3);
            Student student4 = new Student("Kim Bendtsen", "24861379", "kim@gamail.com");
            signedUp4.setPayed(true);
            signedUp4.setYogaclass(yc3);
            signedUp4.setStudent(student4);
            Student student5 = new Student("Lone Sørensen", "32323232", "lone@gamail.com");
            signedUp5.setPayed(true);
            signedUp5.setYogaclass(yc3);
            signedUp5.setStudent(student5);
            Student student6 = new Student("Bettina Bondesen", "88888888", "bettina@gamail.com");
            signedUp6.setPayed(false);
            signedUp6.setYogaclass(yc5);
            signedUp6.setStudent(student6);
            Student student7 = new Student("Grethe Fink", "95731133", "grethe@gamail.com");
            signedUp7.setPayed(false);
            signedUp7.setYogaclass(yc6);
            signedUp7.setStudent(student7);
            
            em.persist(yc1);
            em.persist(yc2);
            em.persist(yc3);
            em.persist(yc4);
            em.persist(yc5);
            em.persist(yc6);
            em.persist(yc7);
            em.persist(yc8);
            em.persist(yc9);
            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);
            em.persist(course5);
            em.persist(course6);
            em.persist(course7);
            em.persist(course8);
            em.persist(signedUp1);
            em.persist(signedUp2);
            em.persist(signedUp3);
            em.persist(signedUp4);
            em.persist(signedUp5);
            em.persist(signedUp6);
            em.persist(signedUp7);
            //em.persist(instructor1);
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);
            em.persist(student7);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}