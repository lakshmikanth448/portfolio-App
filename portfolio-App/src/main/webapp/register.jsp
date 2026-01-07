<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Disable caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    response.setHeader("Pragma", "no-cache"); 
    response.setDateHeader("Expires", 0); 
%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>User Registration</h2>

    <form action="register" method="post" enctype="multipart/form-data">
        Name:
        <input type="text" name="name" required>

        Email:
        <input type="email" name="email" required>

        Password:
        <input type="password" name="password" required>
		
		Skill:
        <input type="Skill" name="Skill" required>
        Education Qualification:
        <input type="edu" name="edu" required>
        Experience:
        <input type="Experience" name="Experience" required>
        Profile Picture:
    <input type="file" name="profilePic" accept="image/*">
        
        <button type="submit">Register</button>
    </form>

    <br>
    Already registered?
    <a href="login.jsp">Login</a>
</div>

</body>
</html>
