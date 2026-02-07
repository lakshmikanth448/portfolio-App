<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.portfolio.model.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() +"/login.jsp");
        return;
    }
%>

<div class="header">
    Welcome, <%= user.getName() %>
    <a href="${pageContext.request.contextPath}/addProject.jsp">Add Project</a>
    <a href="${pageContext.request.contextPath}/viewPortfolio">View Portfolio</a>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>

<div class="container">

    <h2>Dashboard</h2>
    <% if (user.getProfilePic() != null) { %>
        <p>Profile Picture:</p>
        <img src="<%= user.getProfilePic() %>" alt="Profile Picture" style="width:150px; border-radius:50%;">
    <% } else { %>
        <p>No profile picture uploaded.</p>
    <% } %>
    <p>Name: <%= user.getName() %></p>
    <p>Email: <%= user.getEmail() %></p>
    <p>Skills: <%= user.getSkills() %></p>
    <p>Education: <%= user.getEducation() %> </p>
    <p>Experiance: <%= user.getExperience() %> </p>
    
</div>


</body>
</html>


