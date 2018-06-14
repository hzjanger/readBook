<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-7
  Time: 下午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/admin/adminIndex.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <script src="assets/js/admin/index.js"></script>
    <script src="assets/js/admin/insertBook.js"></script>
    <script src="assets/js/admin/deleteBook.js"></script>
    <script src="assets/js/admin/updataBook.js"></script>
    <script src="assets/js/admin/updatePass.js"></script>
</head>
<body>
<%
    String adminUser = String.valueOf(request.getSession().getAttribute("adminUser"));
    System.out.println("adminUser = " + adminUser);
    if ("null".equals(adminUser)) {
        System.out.println("页数");
    }
%>

<% if ("null".equals(adminUser)) {%>
    <jsp:forward page="adminLogin.jsp"></jsp:forward>
<%}%>
<div class="bg-white" style="border-bottom: 1px solid #9FA5AE;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-2" style="background: #F44336;">
                <div class="navbar-admin">
                    Admin
                </div>
            </div>
            <div class="col-10">
                <ul class="nav text-dark justify-content-end nav-overrite">
                    <li class="nav-item dropdown show">
                        <a class="nav-link dropdown-toggle" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="cursor: pointer;"><%=adminUser%></a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="/adminQuit">退出登录</a>
                        </div>
                    </li>
                </ul>
                <%--<ul class="nav justify-content-end">--%>
                    <%--<li class="nav-item">--%>
                        <%--<a class="nav-link nav-link-login" href="#"><%=adminUser%></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 bg-dark" style="background: #1F2837; padding: 0;">
            <jsp:include page="leftMenu.jsp" flush="true"></jsp:include>
        </div>
        <div class="col-10 bg-light show">
            <jsp:include page="insertBook.jsp" flush="true"></jsp:include>
        </div>
        <div class="col-10 bg-light none">
            <jsp:include page="deleteBook.jsp" flush="true"></jsp:include>
        </div>
        <div class="col-10 bg-light none">
            <jsp:include page="updataBook.jsp" flush="true"></jsp:include>
        </div>
        <div class="col-10 bg-light none">
            查找书籍
        </div>
        <div class="col-10 bg-light none">
            <jsp:include page="adminUpdataPass.jsp" flush="true"></jsp:include>
        </div>
    </div>
</div>
</body>
</html>
