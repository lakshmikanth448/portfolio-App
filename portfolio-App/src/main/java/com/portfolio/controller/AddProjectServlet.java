package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.dao.ProjectDAO;
import com.portfolio.model.Project;
import com.portfolio.model.User;

@WebServlet("/addProject")
public class AddProjectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        User user = (User) req.getSession().getAttribute("user");

        Project p = new Project();
        p.setTitle(req.getParameter("title"));
        p.setTechnologies(req.getParameter("tech"));
        p.setDescription(req.getParameter("description"));
        p.setDuration(req.getParameter("duration"));
        p.setProjectLink(req.getParameter("link"));
        p.setUser(user);

        new ProjectDAO().saveProject(p);
        res.sendRedirect(request.getContextPath() + "dashboard.jsp");
    }
}


