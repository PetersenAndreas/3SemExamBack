package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.CourseFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("course")
public class CourseResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Sem3Exam",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final CourseFacade FACADE =  CourseFacade.getCourseFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCourseCount() {
        long count = FACADE.getCourseCount();
        return "{\"count course\":"+count+"}";  //Done manually so no need for a DTO
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCourses() {
       return GSON.toJson(FACADE.getAllCourses());
    }
    
    @Path("allyogaclass")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCoursesWithYogaClass() {
       return GSON.toJson(FACADE.getAllCoursesWithYogaClass());
    }

 
}
