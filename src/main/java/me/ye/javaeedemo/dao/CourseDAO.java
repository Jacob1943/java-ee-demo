package me.ye.javaeedemo.dao;

import me.ye.javaeedemo.entity.Course;

import java.util.List;

/**
 * Created by Jacob on 12/28/2017.
 */

public interface CourseDAO {

    int insert(Course course);
    int update(Course course);
    Course findById(Long id);
    List<Course> findAll();
    Course findByName(String name);
    int deleteById(Long id);
}
