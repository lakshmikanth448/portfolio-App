package com.portfolio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.dao.ProjectDAO;
import com.portfolio.model.Project;
import com.portfolio.model.User;

@WebServlet("/viewPortfolio")
public class ViewPortfolioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        ProjectDAO projectDAO = new ProjectDAO();
        List<Project> projects = projectDAO.getProjectsByUser(user.getId());

        req.setAttribute("user", user);
        req.setAttribute("projects", projects);

        req.getRequestDispatcher("portfolio.jsp").forward(req, resp);
    }
}