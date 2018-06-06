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
</head>
<body>
<%
    String useName = (String) request.getAttribute("usename");
    application.setAttribute("user", useName);
%>
<div class="bg-light">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <nav class="navbar navbar-expand-sm">
                    <a class="navbar-brand" href="../../index.jsp">豆瓣读书</a>
                </nav>
            </div>
            <div class="col-6">
                <form action="/search" method="get">
                    <input type="text" class="form-control form-control-overrite" id="usr" name="key">
                    <button type="submit" class="btn btn-primary search-button">搜索</button>
                </form>
            </div>
            <% if (useName == null) {%>
                <div class="col-4">
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
                <div class="col-4">
                    <ul class="nav text-dark justify-content-end nav-overrite">
                        <li class="nav-item dropdown show">
                            <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown link
                            </a>

                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <%--<li class="head-line">--%>
                            <%--<span class="nav-line">|</span>--%>
                        <%--</li>--%>
                        <%--<li class="nav-item">--%>
                            <%--<a class="nav-link" href="register.jsp">免费注册</a>--%>
                        <%--</li>--%>
                    </ul>
                    <%--<div class="dropdown show">--%>
                        <%--<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                            <%--Dropdown link--%>
                        <%--</a>--%>

                        <%--<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">--%>
                            <%--<a class="dropdown-item" href="#">Action</a>--%>
                            <%--<a class="dropdown-item" href="#">Another action</a>--%>
                            <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
            <%}%>

        </div>
    </div>
</div>
<div class="bg-light" style="border-top: 1px solid #E9E9E2;">
    <div class="container" >
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#">购书单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">电子图书</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">豆瓣书店</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">2017年度榜单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">2017读书报告</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">购物车</a>
            </li>
        </ul>
    </div>
</div>

</div>
</body>
</html>
