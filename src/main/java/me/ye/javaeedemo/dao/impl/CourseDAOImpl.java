package me.ye.javaeedemo.dao.impl;

import me.ye.javaeedemo.dao.CourseDAO;
import me.ye.javaeedemo.entity.Course;
import me.ye.javaeedemo.util.JDBCUtils;

import java.sql.Connection;
import java.util.logging.Logger;

/**
 * Created by Jacob on 12/28/2017.
 */

public class CourseDAOImpl implements CourseDAO {

    private static final Logger LOGGER = Logger.getLogger("CourseDAO");

    @Override
    public void insert(Course course) {

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public Course findById(Long id) {
        Connection connection = null;
        Course course = null;
        try {
            connection = JDBCUtils.getConnection();

        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        }

        return course;
    }
}
