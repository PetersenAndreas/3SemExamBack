package facades;

import dto.CourseDTO;
import dto.YogaClassDTO;
import entities.Course;
import entities.RenameMe;
import entities.YogaClass;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CourseFacade {

    private static CourseFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CourseFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CourseFacade getCourseFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getCourseCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long courseCount = (long)em.createQuery("SELECT COUNT(c) FROM Course c").getSingleResult();
            return courseCount;
        }finally{  
            em.close();
        }
    }
    
    public List<CourseDTO> getAllCourses() {
        EntityManager em = getEntityManager();
        List<CourseDTO> cDTOList = new ArrayList();
        //List<YogaClassDTO> ycDTOList = new ArrayList();
        try {
            TypedQuery<Course> q = em.createNamedQuery("Course.getAll", Course.class);
            for (Course c : q.getResultList()) {
                //ycDTOList.add();
                cDTOList.add(new CourseDTO(c));
            }
            return cDTOList;
        } finally {
            em.close();
        }
    }
    
//    public CourseDTO getAllCoursesWithYogaClass(YogaClassDTO ycDTO) {
//        EntityManager em = getEntityManager();
//        List<CourseDTO> cDTOList = new ArrayList();
//        try {
//            em.getTransaction().begin();
//            Course course = em.find(Course.class, ycDTO.getId());
//            em.getTransaction().commit();
//            CourseDTO cDTO = new CourseDTO(course);
//            return cDTO;
//        } finally {
//            em.close();
//        }
//    }
    
   public List<CourseDTO> getAllCoursesWithYogaClass() {
        EntityManager em = getEntityManager();
        List<CourseDTO> cDTOList = new ArrayList();
        List<YogaClassDTO> ycDTOList = new ArrayList();
        try {
            TypedQuery<Course> q = em.createNamedQuery("Course.getAll", Course.class);
            for (Course c : q.getResultList()) {
                //cDTOList.add(new CourseDTO(c));
                for(YogaClass yc : c.getYogaClasss()) {
                    ycDTOList.add(new YogaClassDTO(yc));
                }
                CourseDTO cDTO = new CourseDTO(c);
                cDTO.setYogaClasss(ycDTOList);
                cDTOList.add(cDTO);
            }
            return cDTOList;
        } finally {
            em.close();
        }
    }

}
