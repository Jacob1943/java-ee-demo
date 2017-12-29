package me.ye.javaeedemo.dao;

import me.ye.javaeedemo.dao.impl.CourseDAOImpl;
import me.ye.javaeedemo.entity.Course;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jacob on 12/29/2017.
 */


public class CourseDAOTest {

    private CourseDAO courseDAO;

    @Before
    public void setUp() {
        this.courseDAO = new CourseDAOImpl();
    }

    @Test
    public void testFindById() {
        Course course = courseDAO.findById(1l);
        assertEquals("计算机基础", course.getName());
        assertEquals("张三", course.getLecturer());
        assertEquals("必修", course.getCategory());
    }

    @Test
    public void testFindAll() {
        List<Course> list = courseDAO.findAll();
        assertEquals(3, list.size());
    }


    @Test
    public void testFindByName() {
        Course course = courseDAO.findByName("计算机基础");
        assertEquals("张三", course.getLecturer());
        assertEquals("必修", course.getCategory());
    }

    @Test
    public void testInsert() {
        Course course = new Course();
        course.setName("test");
        course.setLecturer("test");
        course.setCategory("test");
        assertEquals(1, courseDAO.insert(course));
        course = courseDAO.findByName("test");
        assertEquals(1, courseDAO.deleteById(course.getId()));
    }

    @Test
    public void testUpdate() {
        Course course = new Course();
        course.setName("test");
        course.setLecturer("test");
        course.setCategory("test");
        assertEquals(1, courseDAO.insert(course));
        course = courseDAO.findByName("test");
        course.setName("testUpdate");
        assertEquals(1, courseDAO.update(course));
        assertEquals("testUpdate", courseDAO.findById(course.getId()).getName());
        assertEquals(1, courseDAO.deleteById(course.getId()));
    }

}
