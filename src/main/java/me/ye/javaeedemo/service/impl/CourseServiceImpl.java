package me.ye.javaeedemo.service.impl;

import me.ye.javaeedemo.dao.CourseDAO;
import me.ye.javaeedemo.dao.impl.CourseDAOImpl;
import me.ye.javaeedemo.entity.Course;
import me.ye.javaeedemo.service.CourseService;

import java.util.List;

/**
 * Created by Jacob on 12/29/2017.
 */
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    public CourseServiceImpl() {
        this.courseDAO = new CourseDAOImpl();
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }
}
