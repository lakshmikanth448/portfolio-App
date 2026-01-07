package com.portfolio.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.portfolio.model.Project;
import com.portfolio.util.HibernateUtil;

@WebServlet("/deleteProject")
public class DeleteProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int projectId = Integer.parseInt(req.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Project project = session.get(Project.class, projectId);

        if (project != null) {
            session.delete(project);
        }

        tx.commit();
        session.close();

        resp.sendRedirect("dashboard.jsp");
    }
}

