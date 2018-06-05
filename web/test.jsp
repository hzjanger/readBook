<%@ page import="user.User" %>
<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-5
  Time: 下午1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book = new Book();
    book.setBook_name("hello");
%>
<h1><%=book.getBook_name()%></h1>
</body>
</html>
