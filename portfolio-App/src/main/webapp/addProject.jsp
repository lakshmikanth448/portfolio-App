<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Project</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Add New Project</h2>

    <form action="addProject" method="post">
        Project Title:
        <input type="text" name="title" required>

        Description:
        <textarea name="description" rows="4"></textarea>

        Technologies:
        <input type="text" name="tech">

        Duration:
        <input type="text" name="duration">

        Project Link:
        <input type="url" name="link">

        <button type="submit">Save Project</button>
    </form>

    <br>
    <a href="dashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
