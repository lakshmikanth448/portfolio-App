package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.dao.UserDAO;
import com.portfolio.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Handles GET requests (like opening the login page)
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.sendRedirect(request.getContextPath() + "login.jsp");
    }

    // Handles POST requests (form submission)
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        User user = new UserDAO().login(
            req.getParameter("email"),
            req.getParameter("password"));

        if(user != null) {
            req.getSession().setAttribute("user", user);
            res.sendRedirect(request.getContextPath() + "dashboard.jsp");
        } else {
            res.sendRedirect(request.getContextPath() + "login.jsp?error=true");
        }
    }
}









