package me.ye.javaeedemo.dao;

import me.ye.javaeedemo.entity.Course;

/**
 * Created by Jacob on 12/28/2017.
 */

public interface CourseDAO {

    void insert(Course course);
    void update(Course course);
    Course findById(Long id);
}
