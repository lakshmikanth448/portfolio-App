<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // If user is already logged in, go to dashboard
    if (session.getAttribute("user") != null) {
        response.sendRedirect("dashboard.jsp");
    } else {
        // Otherwise, go to login page
        response.sendRedirect("login.jsp");
    }
%>
