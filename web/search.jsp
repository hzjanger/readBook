<%@ page import="layout.ShowSearch" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-2
  Time: 上午8:15
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
    <link rel="stylesheet" href="assets/css/search/book-list.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<%
    List<Book> list = (List<Book>) request.getAttribute("search");
    int amount = (int) request.getAttribute("amount");
    Iterator iterator = list.iterator();
    Book book = new Book();
%>

<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <h2 class="search-value">搜索 <%=request.getAttribute("search_value")%></h2>
    <h5 class="search-amount">为您找到<%=amount%>本书籍</h5>
    <% while (iterator.hasNext()) {
        book = (Book) iterator.next();
    %>
    <div class="row book-list">
        <div class="col-1">
            <img class="img-fluid" src="<%=book.getBook_img()%>" referrerpolicy ="never">
        </div>
        <div class="col-11">
            <p><a href="/subject/<%=book.getISBN()%>"><%=book.getBook_name()%></a></p>
            <p>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                <%=book.getReview_grade()%>
            </p>
            <p class="author">
                <%=book.getAuthor()%>
                <% if (book.getTranslators() != null) {%>
                / <%=book.getTranslators()%>
                <%}%>
                <% if (book.getPubliseer() != null) {%>
                / <%=book.getPubliseer()%>
                <%}%>
                <% if (book.getPutlish_time() != null) {%>
                / <%=book.getPutlish_time()%>/
                <%}%>
                <% if (book.getPrice() != null) {%>
                <%=book.getPrice()%>
                <%}%>
            </p>


        </div>
    </div>
    <%}%>

    <div class="row" style="margin-top: 1rem;margin-bottom: 0rem;">
        <ul class="pagination">
            <li class="page-item"><a class="page-link">上一页</a></li>
            <li class="page-item"><a class="page-link">1</a></li>
            <li class="page-item"><a class="page-link">2</a></li>
            <li class="page-item"><a class="page-link">3</a></li>
            <li class="page-item"><a class="page-link">4</a></li>
            <li class="page-item"><a class="page-link">5</a></li>
            <li class="page-item"><a class="page-link">6</a></li>
            <li class="page-item"><a class="page-link">...</a></li>
            <li class="page-item"><a class="page-link">下一页</a></li>
        </ul>
    </div>
</div>
<div class="bg-light" style="margin-top: 2rem;margin-bottom: 2rem;">
    <div class="container">
        页脚
    </div>
</div>
</body>
</html>
