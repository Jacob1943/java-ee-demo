<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 12/25/2017
  Time: 3:05 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的课程</title>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/css/my.css">
</head>
<body>
<%@ include file="../navbar.jsp"%>
<div class="table-responsive">
    <table class="table table-hover">
        <thead>
        <tr>
            <td>课程名称</td>
            <td>讲师</td>
            <td>课程类别</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageContext.request.getAttribute(\"courses\")}" var="course">
            <tr>
                <td>${course.getName()}</td>
                <td>${course.getLecturer()}</td>
                <td>${course.getCategory()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="../static/js/jquery-3.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>
