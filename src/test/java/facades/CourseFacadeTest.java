package facades;

import dto.CourseDTO;
import entities.Course;
//import entities.Instructor;
import utils.EMF_Creator;
import entities.RenameMe;
import entities.SignedUp;
import entities.Student;
import entities.YogaClass;
import errorhandling.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class CourseFacadeTest {

    private static EntityManagerFactory emf;
    private static CourseFacade facade;

    public CourseFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Sem3Exam_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = CourseFacade.getCourseFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.CREATE);
        facade = CourseFacade.getCourseFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        List<YogaClass> yoga1 = new ArrayList();
        //List<Instructor> instructors1 = new ArrayList();

        YogaClass yc1 = new YogaClass(12, 50);
        yoga1.add(yc1);

        //Instructor instructor1 = new Instructor("Kim", yoga1);
        //instructors1.add(instructor1);

        //yc1.setInstructors(instructors1);

        Course course1 = new Course("Hot yoga", "It is hot", yoga1);
        yc1.setCourse(course1);
        
        Course course2 = new Course("Normal yoga", "It is normal", yoga1);
        yc1.setCourse(course2);

        //Student 1
        SignedUp signedUp1 = new SignedUp();
        Student student1 = new Student("Lars Larsen", "12345678", "larsen@gamail.com");
        signedUp1.setPayed(false);
        signedUp1.setYogaclass(yc1);
        signedUp1.setStudent(student1);
        
        //Student2
        SignedUp signedUp2 = new SignedUp();
        Student student2 = new Student("Bo Bosen", "87654321", "bosen@gamail.com");
        signedUp2.setPayed(true);
        signedUp2.setYogaclass(yc1);
        signedUp2.setStudent(student2);

        try {
            em.getTransaction().begin();
            //em.createNamedQuery("Instructor.deleteAllRows").executeUpdate();
            em.createNamedQuery("SignedUp.deleteAllRows").executeUpdate();
            em.createNamedQuery("Student.deleteAllRows").executeUpdate();
            em.createNamedQuery("YogaClass.deleteAllRows").executeUpdate();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();

            em.persist(yc1);
            em.persist(course1);
            em.persist(course2);
            em.persist(signedUp1);
            em.persist(signedUp2);
            //em.persist(instructor1);
            em.persist(student1);
            em.persist(student2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getCourseCount());
    }
    
    @Test
    public void testGetAllCourses() throws NotFoundException {
        int ExpectedSize = 2;
        List<CourseDTO> courses = facade.getAllCourses();
        assertEquals(ExpectedSize, courses.size());
    }

    @Test
    public void testGetAllCoursesWithClass() throws NotFoundException {
        int ExpectedSize = 2;
        List<CourseDTO> courses = facade.getAllCoursesWithYogaClass();
        assertEquals(ExpectedSize, courses.size());
    }

}
