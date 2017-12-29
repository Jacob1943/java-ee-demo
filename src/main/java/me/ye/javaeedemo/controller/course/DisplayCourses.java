package me.ye.javaeedemo.controller.course;

import me.ye.javaeedemo.entity.Course;
import me.ye.javaeedemo.service.CourseService;
import me.ye.javaeedemo.service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 12/25/2017.
 */
@WebServlet(name = "DisplayCourses", value = "/courses/display")
public class DisplayCourses extends HttpServlet {

    private CourseService courseService;

    public DisplayCourses() {
        this.courseService = new CourseServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> courses = courseService.findAll();
        req.setAttribute("courses", courses);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/course/display.jsp");
        dispatcher.forward(req, resp);
    }
}
