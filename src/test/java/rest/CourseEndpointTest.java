package rest;

import entities.Course;
import entities.RenameMe;
import entities.User;
import entities.Role;
import entities.SignedUp;
import entities.Student;
import entities.YogaClass;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

//@Disabled
public class CourseEndpointTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static RenameMe r1, r2;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.CREATE);

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the EntityClass used below to use YOUR OWN (renamed) Entity class
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

    @Test
    public void testServerIsUp() {
        System.out.println("Testing is server UP");
        given().when().get("/course").then().statusCode(200);
    }

}