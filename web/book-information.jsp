<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-2
  Time: 上午9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":"+request.getServerPort()+path+ "/" ;
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/base/base.css">
    <link rel="stylesheet" href="assets/css/book-information/information.css">
    <link rel="stylesheet" href="assets/css/book-information/review.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<%
    //获取书籍信息
    Book book = (Book) request.getAttribute("info");
    //获取书籍介绍信息
    List<String> book_introduction = (List<String>) request.getAttribute("introduction");
    Iterator<String> iterator = null;
    if (book_introduction != null) {
        iterator = book_introduction.iterator();
    }
    //获取书目录
    List<String> directory = (List<String>) request.getAttribute("directory");
    Iterator<String> iterator_directory = null;
    if (directory != null) {
        iterator_directory = directory.iterator();
    }

    List<String> author_troduction = (List<String>) request.getAttribute("author_troduction");
    Iterator<String> iterator_author_troduction = null;
    System.out.println(author_troduction);
    if (author_troduction != null) {
        System.out.println(666);
        iterator_author_troduction = author_troduction.iterator();
//        while (i)
    }

%>
<%--头部信息--%>
<jsp:include page="head.jsp"></jsp:include>

<div class="container">
    <h2 class="book-name"><%=book.getBook_name()%></h2>
    <div class="row book-information">
        <div class="col-2">
            <img src="<%=book.getBook_img()%>" referrerpolicy ="never" alt="图书" class="img-fluid">
        </div>
        <div class="col-7">
            <p>作者: <a href="#" class="author"><%=book.getAuthor()%></a></p>
            <% if (book.getPubliseer() != "" ) {%>
                <p>出版社: <span><%=book.getPubliseer()%></span></p>
            <%}%>
            <% if (book.getTranslators() != "" ) {%>
                <p>译者: <a href="#"><%=book.getTranslators()%></a></p>
            <%}%>
            <% if (book.getPutlish_time() != "" ) {%>
                <p>出版年: <span><%=book.getPutlish_time()%></span></p>
            <%}%>
            <% if (book.getPage_amount() != "" ) {%>
                <p>页数: <span><%=book.getPage_amount()%></span></p>
            <%}%>
            <% if (book.getBinding() != "" ) {%>
                <p>装帧: <span><%=book.getBinding()%></span></p>
            <%}%>
            <% if (book.getISBN() != "" ) {%>
                <p>ISBN: <span><%=book.getISBN()%></span></p>
            <%}%>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <% if (book_introduction != null) {%>
            <div class="col-12">
                <p class="introduction">内容简介  · · · · · · </p>
            </div>
            <div class="col-12 introduction-container">
                <%--动态的渲染书籍的内容简介--%>
                <% while (iterator.hasNext()) {%>
                    <p><%=iterator.next()%></p>
                <%}%>
            </div>
        <%}%>
        <div class="col-12">
            <p class="introduction">作者简介  · · · · · · </p>
        </div>
        <div class="col-12 introduction-container">
            <% while (iterator_author_troduction.hasNext()) {%>
                <p><%=iterator_author_troduction.next()%></p>
            <%}%>
        </div>
        <% if (directory != null) {%>
        <div class="col-12">
            <p class="introduction">目录  · · · · · · </p>
        </div>
        <div class="col-12 introduction-container">
            <% while (iterator_directory.hasNext()) {%>
                <p><%=iterator_directory.next()%></p>
            <%}%>
        </div>
        <%}%>

    </div>
</div>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
