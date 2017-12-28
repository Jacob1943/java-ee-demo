package me.ye.javaeedemo.controller.course;

import me.ye.javaeedemo.entity.Course;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course(1l, "计算机基础", "张三","必修");
        Course course2 = new Course(2l, "计算机网络", "李四","必修");
        Course course3 = new Course(3l, "Microsoft Office", "王五","选修");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        req.setAttribute("courses", courses);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/course/display.jsp");
        dispatcher.forward(req, resp);
    }
}
