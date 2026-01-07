<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.portfolio.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Portfolio</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%
    User user = (User) request.getAttribute("user");
    List<Project> projects = (List<Project>) request.getAttribute("projects");
%>

<div class="container">
    <h2><%= user.getName() %>'s Portfolio</h2>

    <p><b>Email:</b> <%= user.getEmail() %></p>
    <p><b>Skills:</b> <%= user.getSkills() %></p>
    <p><b>Education:</b> <%= user.getEducation() %></p>
    <p><b>Experience:</b> <%= user.getExperience() %></p>

    <hr>

    <h3>Projects</h3>

    <%
        for (Project p : projects) {
    %>
        <div class="project-card">
            <h4><%= p.getTitle() %></h4>
            <p><%= p.getDescription() %></p>
            <p><b>Tech:</b> <%= p.getTechnologies() %></p>
            <p><b>Duration:</b> <%= p.getDuration() %></p>

            <a href="<%= p.getProjectLink() %>" target="_blank">Project Link</a>
            |
            <a href="deleteProject?id=<%= p.getId() %>"
               onclick="return confirm('Delete this project?')">
               Delete
            </a>
        </div>
    <%
        }
    %>

    <br>
    <a href="dashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
