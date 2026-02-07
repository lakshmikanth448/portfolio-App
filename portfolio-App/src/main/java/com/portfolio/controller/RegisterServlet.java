package com.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.portfolio.dao.UserDAO;
import com.portfolio.model.User;

@WebServlet("/register")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 15    // 15MB
	)
public class RegisterServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        User u = new User();
        u.setName(req.getParameter("name"));
        u.setEmail(req.getParameter("email"));
        u.setPassword(req.getParameter("password"));
        u.setSkills(req.getParameter("Skill"));
        u.setEducation(req.getParameter("edu"));
        u.setExperience(req.getParameter("Experience"));

        // Handle profile picture upload
        Part filePart = req.getPart("profilePic");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            u.setProfilePic(UPLOAD_DIR + "/" + fileName); // save relative path in DB
        }
        
       


        new UserDAO().saveUser(u);
        res.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}


