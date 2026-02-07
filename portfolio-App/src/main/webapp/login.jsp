<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Disable caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    
%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>User Login</h2>

    <form action="<%= request.getContextPath() %>/login" method="post">
        Email:
        <input type="email" name="email" required>

        Password:
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <br>
    New user?
    <a href="<%= request.getContextPath() %>/register.jsp">Register</a>

    <%
        if (request.getParameter("error") != null) {
    %>
        <p style="color:red;">Invalid email or password</p>
    <%
        }
    %>
</div>

</body>
</html>


