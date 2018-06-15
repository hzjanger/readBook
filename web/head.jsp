<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-6
  Time: 下午5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/css/index/head.css">
    <%--<link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">--%>
    <%--<link rel="stylesheet" href="assets/css/base/base.css">--%>
    <script src="assets/js/jquery-3.3.1.js"></script>
    <%--<script src="assets/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"></script>--%>
    <%--<script src="assets/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>--%>
    <script src="assets/js/index/head.js"></script>
    <script src="assets/js/person/person.js"></script>
</head>
<body>
<%
    String useName = String.valueOf(request.getSession().getAttribute("user"));
    String user_img = String.valueOf(request.getSession().getAttribute("user_img"));
    if ("null".equals(user_img)) {
        user_img = "//img.mukewang.com/533e4d5b0001d57502200203-200-200.jpg";
    }
%>
<div class="bg-light head-box">
    <div class="container">
        <div class="row">
            <div class="col-4 col-sm-7 col-md-2 col-lg-2">
                <nav class="navbar navbar-expand-sm">
                    <a class="navbar-brand" href="../../index.jsp">豆瓣读书</a>
                </nav>
            </div>
            <div class="col-md-6 col-lg-6 hidden">
                <form action="/search" method="get">
                    <input type="text" class="form-control form-control-overrite" id="usr" name="key" placeholder="书籍名、作者名">
                    <input type="text" name="type" style="display: none;" value="search">
                    <button type="submit" class="btn btn-primary search-button">搜索</button>
                </form>
            </div>
            <% if (useName.equals("null")) {%>
                <div class="col-8 col-sm-5 col-md-4 col-lg-4">
                    <ul class="nav text-dark justify-content-end nav-overrite">
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">登录</a>
                        </li>
                        <li class="head-line">
                            <span class="nav-line">|</span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">免费注册</a>
                        </li>
                    </ul>
                </div>
            <%} else {%>
                <div class="col-8 col-sm-5 col-md-4 col-lg-4">
                    <div class="row">
                        <div class="col-8"></div>
                        <div class="col-4">
                            <img src="<%=user_img%>" id="head-img" class="img-fluid rounded-circle nav-img"  style="max-width: 50px">
                            <a class="nav-link dropdown-toggle" role="button" id="dropdownMenuLink" style="display: none;"><%=useName%></a>
                            <ul class="nav menu-nav none bg-white" style="position: absolute;">
                                <li class="nav-item">
                                    <a class="nav-link person-center" href="#">个人中心</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/quit">退出登录</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            <%}%>

        </div>
    </div>
</div>
</div>
</body>
</html>
