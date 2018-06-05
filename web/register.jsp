<%@ page import="user.User" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-3
  Time: 上午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/register/register.css">
    <link rel="stylesheet" href="assets/css/base/myself.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/js/register/register.js"></script>
</head>
<body>
<%
    User user = new User();
%>
<div class="container-fluid" style="padding-bottom: 23px;">
    <div class="row">
        <div class="col-12">
            <h1>kirin</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-4 login-box" style="margin: 0 auto;">
            <div>
                <p class="text-center">注册</p>
            </div>
            <form name="form" action="/register" method="post" onsubmit="return check(form)">
                <div class="form-group">
                    <label for="username">昵称:</label>
                    <input type="text" class="form-control" id="username" name="user" placeholder="<%=user.getUsername()%>">
                    <div class="alert alert-danger check-user display"></div>
                </div>
                <div class="form-group">
                    <label for="email">邮箱:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="<%=user.getEmail()%>">
                    <div class="alert alert-danger check-email display"></div>
                </div>
                <div class="form-group">
                    <label for="psw">设置密码:</label>
                    <input type="password" class="form-control" id="psw" name="pass" placeholder="<%=user.getPassword()%>">
                    <div class="alert alert-danger check-pass display"></div>
                </div>
                <div class="form-group">
                    <label for="repsw">确认密码:</label>
                    <input type="password" class="form-control" name="passsure" id="repsw" placeholder="<%=user.getPasswordSure()%>">
                    <div class="alert alert-danger check-passsure display"></div>
                </div>
                <div style="margin-top: 1rem;">
                    <button class="btn btn-primary btn-block">注册</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
