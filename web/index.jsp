<%@ page import="entity.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="test.Test" %>
<%@ page import="layout.ShowIndex" %>
<%@ page import="layout.PopularBook" %>
<%@ page import="database.GetDatabase" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-1
  Time: 下午7:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":"+request.getServerPort()+path+ "/" ;
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/index/index.css">
    <link rel="stylesheet" href="assets/css/base/base.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <script src="assets/js/index/index.js"></script>
</head>
<body>

<%

    ShowIndex showIndex = new ShowIndex();
    //    获取推荐书籍
    showIndex.getBook("root", "3");
//    System.out.println(showIndex.getList());
    Iterator<Book> iterator = showIndex.getList().iterator();
//    showIndex.getBook("root", "2");
    ShowIndex showIndexSell = new ShowIndex();
    //获取畅销图书
    showIndexSell.getBook("root", "2");
    Iterator<Book> iterator_sell_well = showIndexSell.getList().iterator();

    ShowIndex douban_like = new ShowIndex();
    douban_like.getBook("root", "1");
    Iterator<Book> iterator_douban_like = douban_like.getList().iterator();
    PopularBook popularBook = new PopularBook();
    //获取受关注的书籍
    popularBook.getPopularBook();
    Iterator<Book> iterator_popular_book = popularBook.getList().iterator();
%>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<div class="bg-white">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-8">
                <%--新书速递--%>
                <h2 class="head">
                    <span class="new-book">推荐书籍</span>
                </h2>
                <div class="row">
                    <%
                        //通过迭代在页面上渲染书籍的信息
                        while (iterator.hasNext()) {
                            Book recommend_book = iterator.next();
                    %>
                    <div class="col-4 col-sm-3">
                        <div class="card card-overrite">
                            <a href="/subject/<%=recommend_book.getISBN()%>">
                                <img src="<%=recommend_book.getBook_img()%>" referrerpolicy="never" class="img-fluid">
                            </a>
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="/subject/<%=recommend_book.getISBN()%>"><%=recommend_book.getBook_name()%></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
                <%--最受关注图书榜    --%>
                <h2 class="head">
                    <span class="new-book">最受关注图书榜</span>
                </h2>
                <div class="row">
                    <%while (iterator_popular_book.hasNext()) {
                        Book popular_book = iterator_popular_book.next();
                    %>
                    <div class="col-6">
                        <div class="row">
                            <div class="col-5">
                                <a href="/subject/<%=popular_book.getISBN()%>">
                                    <img src="<%=popular_book.getBook_img()%>" class="img-fluid" referrerpolicy="never">
                                </a>
                            </div>
                            <div class="col-7">
                                <p><a href="/subject/<%=popular_book.getISBN()%>"><%=popular_book.getBook_name()%></a></p>
                                <p>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                    <%=popular_book.getReview_grade()%>
                                </p>
                                <p><%=popular_book.getAuthor()%></p>
                                <p>毛姆 / 短篇小说 </p>
                            </div>
                        </div>
                        <div class="row" style="margin-top: .7rem;margin-bottom: .7rem;">
                            <div class="col-12" style="padding-right: 1rem;">
                                <p class="reviews">喜欢与短篇小说中的毛姆叔叔做朋友，走进书页中，听他诉说一个个离奇浪漫的事件，然后无拘无束得开怀大笑。 (二呆评论) </p>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-4">
                <h2 class="head">
                    <span class="new-book">畅销图书榜</span>
                </h2>
                <div class="sell-well-book">
                    <ul class="ul-nav">
                        <% while (iterator_sell_well.hasNext()) {
                            Book sell_well_book = iterator_sell_well.next();
                        %>
                        <li class="ul-nav-item">
                            <a href="/subject/<%=sell_well_book.getISBN()%>"><%=sell_well_book.getBook_name()%></a>
                            <p class="author"><%=sell_well_book.getAuthor()%></p>
                        </li>
                        <%}%>
                    </ul>
                </div>
                <h2 class="head">
                    <span class="new-book">豆瓣图书250</span>
                </h2>
                <div class="row">
                    <% while (iterator_douban_like.hasNext()) {
                        Book douban_like_book = iterator_douban_like.next();
                    %>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <a href="/subject/<%=douban_like_book.getISBN()%>">
                                <img src="<%=douban_like_book.getBook_img()%>" referrerpolicy="never" class="img-fluid">
                            </a>
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="/subject/<%=douban_like_book.getISBN()%>"><%=douban_like_book.getBook_name()%></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
