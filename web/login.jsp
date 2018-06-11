<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-3
  Time: 上午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/login/login.css">
    <link rel="stylesheet" href="assets/css/base/myself.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.js"></script>
    <script src="assets/js/login/login.js"></script>
</head>
<body>
<div class="container-fluid" style="padding-bottom: 23px;">
    <div class="row">
        <div class="col-12">
            <h1>kirin</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-4 login-box" style="margin: 0 auto;">
            <div>
                <p class="text-center">登录</p>
            </div>
            <form name="login_form" action="/login" method="post" onsubmit="return check(login_form)">
                <div class="form-group">
                    <label for="username">用户名:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                    <div class="alert alert-danger alert-dismissable fade show display check-username"></div>
                </div>
                <div class="form-group">
                    <label for="psw">密码:</label>
                    <input type="password" class="form-control" id="psw" name="password" placeholder="密码">
                    <div class="alert alert-danger alert-dismissable fade show display check-password"></div>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox"> 记住密码
                    </label>
                </div>
                <div style="margin-top: 1rem;">
                    <button type="submit" class="btn btn-primary btn-block">登录</button>
                </div>
                <div style="margin-top: 1rem;">
                    <a class="btn btn-primary btn-block" href="./register.jsp">注册</a>
                </div>
                <div class="form-check" style="margin-top: 1rem">
                    <label class="form-check-label">
                        <a>忘记密码</a>
                    </label>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
