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
</head>
<body>
<%
    Book book = (Book) request.getAttribute("insertBook");
    if (book != null) {
        System.out.println(book);
    }
%>
<div class="bg-white" style="border-bottom: 1px solid #9FA5AE;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-2" style="background: #F44336;">
                <div class="navbar-admin">
                    Admin
                </div>
            </div>
            <div class="col-10">
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link nav-link-login" href="#">登录</a>
                    </li>
                </ul>
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
            <jsp:include page="checkBook.jsp" flush="true"></jsp:include>
        </div>
        <div class="col-10 bg-light none">
            查找书籍
        </div>
        <div class="col-10 bg-light none">
            修改密码
        </div>
    </div>
</div>
</body>
</html>
