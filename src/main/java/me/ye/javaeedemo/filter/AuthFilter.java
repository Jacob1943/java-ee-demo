package me.ye.javaeedemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jacob on 12/29/2017.
 */

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/courses/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        //验证ticket
        if (true) {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath());
        }
    }

    @Override
    public void destroy() {

    }
}
