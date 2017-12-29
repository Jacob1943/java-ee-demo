package me.ye.javaeedemo.dao.impl;

import me.ye.javaeedemo.dao.CourseDAO;
import me.ye.javaeedemo.entity.Course;
import me.ye.javaeedemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Jacob on 12/28/2017.
 */

public class CourseDAOImpl implements CourseDAO {

    private static final Logger LOGGER = Logger.getLogger("CourseDAO");

    @Override
    public int insert(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "INSERT INTO course(name, lecturer, category) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(SQL);
            statement.setString(1, course.getName());
            statement.setString(2, course.getLecturer());
            statement.setString(3, course.getCategory());
            LOGGER.info("Execute update: " + SQL);
            result = statement.executeUpdate();
            LOGGER.info("insert one course");
        } catch(Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(null, statement, connection);
        }
        return result;
    }

    @Override
    public int update(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "UPDATE course SET name=?, lecturer=?, category=? WHERE id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setString(1, course.getName());
            statement.setString(2, course.getLecturer());
            statement.setString(3, course.getCategory());
            statement.setLong(4, course.getId());
            LOGGER.info("Execute update: " + SQL);
            result = statement.executeUpdate();
            LOGGER.info("update successfully");
        } catch(Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(null, statement, connection);
        }
        return result;
    }

    @Override
    public Course findById(Long id) {
        Connection connection = null;
        Course course = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "SELECT * FROM course WHERE id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setLong(1, id);
            LOGGER.info("Execute query: " + SQL);
            resultSet = statement.executeQuery();
            course = new Course();
            while (resultSet.next()) {
                course.setId(resultSet.getLong(1));
                course.setName(resultSet.getString(2));
                course.setLecturer(resultSet.getString(3));
                course.setCategory(resultSet.getString(4));
            }
            LOGGER.info("Get course where id is " + id + " successfully");
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }

        return course;
    }

    @Override
    public List<Course> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Course> courseList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM course";
            LOGGER.info("Execute query: " + SQL);
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getLong(1));
                course.setName(resultSet.getString(2));
                course.setLecturer(resultSet.getString(3));
                course.setCategory(resultSet.getString(4));
                courseList.add(course);
            }
            LOGGER.info("fetch all courses successfully");
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }

        return courseList;

    }

    @Override
    public int deleteById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "DELETE FROM course WHERE id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setLong(1, id);
            LOGGER.info("Execute: " + SQL);
            result = statement.executeUpdate();
            LOGGER.info("delete course where id = " + id);
        } catch(Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(null, statement, connection);
        }
        return result;
    }

    @Override
    public Course findByName(String name) {
        Connection connection = null;
        Course course = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "SELECT * FROM course WHERE name = ?";
            statement = connection.prepareStatement(SQL);
            statement.setString(1, name);
            LOGGER.info("Execute query: " + SQL);
            resultSet = statement.executeQuery();
            course = new Course();
            while (resultSet.next()) {
                course.setName(resultSet.getString(2));
                course.setId(resultSet.getLong(1));
                course.setLecturer(resultSet.getString(3));
                course.setCategory(resultSet.getString(4));
            }
            LOGGER.info("Get course where name is " + name + " successfully");
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }

        return course;
    }
}
