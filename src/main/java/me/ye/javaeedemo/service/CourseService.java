package me.ye.javaeedemo.service;

import me.ye.javaeedemo.entity.Course;

import java.util.List;

/**
 * Created by Jacob on 12/29/2017.
 */

public interface CourseService {

    List<Course> findAll();
}
