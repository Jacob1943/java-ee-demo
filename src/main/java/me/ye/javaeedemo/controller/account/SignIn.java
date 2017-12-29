package me.ye.javaeedemo.controller.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jacob on 12/29/2017.
 */

@WebServlet(name = "SignIn", value="/signIn")
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //验证用户是否正确

        HttpSession session = req.getSession();
        session.setAttribute("ticket", "ticket");
        resp.sendRedirect(req.getContextPath() + "/courses/display");
    }
}
