<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课系统</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/my.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">
    <h2>欢迎登录</h2>
    <form class="col-lg-3 col-md-6" method="post" action="${pageContext.request.contextPath}/signIn">
        <div class="form-group">
            <label for="account">账号</label>
            <input type="text" class="form-control" placeholder="账号" id="account">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" placeholder="密码" id="password">
        </div>
        <button class="btn btn-primary" type="submit" >登录</button>
    </form>
</div>

<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>