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
    PopularBook popularBook = new PopularBook();
//    调用showIndex的一个方法
    showIndex.getBook("root");
    popularBook.getPopularBook();
    //获取从数据库中的返回的数据
    Iterator<Book> iterator = showIndex.getList().iterator();
    Iterator<Book> iterator_popular_book = popularBook.getList().iterator();
//    while (iterator_popular_book.hasNext()) {
//        System.out.println(iterator_popular_book.next().getBook_name());
//    }
%>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<div class="bg-white">
    <div class="container">
        <div class="row">
            <div class="col-8">
                <%--新书速递--%>
                <h2 class="head">
                    <span class="new-book">新书速递</span>
                </h2>
                <div class="row">
                    <%
                        //通过迭代在页面上渲染书籍的信息
                        while (iterator.hasNext()) {
                            Book recommend_book = iterator.next();
                    %>
                    <div class="col-3">
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
                                    8.9
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
                <%--最受欢迎的书评   --%>
                <h2 class="head">
                    <span class="new-book">最受欢迎的书评</span>
                </h2>
                <div class="row">
                    <div class="col-12">
                        <div class="row" style="margin-bottom: 1rem; border-bottom: 1px solid #EAEAEA;">
                            <div class="col-2">
                                <img src="assets/img/2.jpg" class="img-fluid">
                            </div>
                            <div class="col-10 assess">
                                <p><a href="#" class="book-name">此刻不要回头</a></p>
                                <p>
                                    <a href="#" class="author">申仙</a>
                                    评论<a href="#" class="assess-book-name">候鸟的勇敢</a>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                </p>
                                <p style="color: #000;">
                                    每年从北方飞到南方，再从南方飞回北方，一年要行经多少公里我不知道，一路上要停靠在哪一个地方略作小憩我也不知道，可我知道，无论是遇到台风还是暴雨，每年的这个时候，它们都会飞回来，只要你愿意等，就一定...
                                    <a href="#">(全文)</a>
                                </p>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 1rem;border-bottom: 1px solid #EAEAEA;">
                            <div class="col-2">
                                <img src="assets/img/2.jpg" class="img-fluid">
                            </div>
                            <div class="col-10 assess">
                                <p><a href="#" class="book-name">此刻不要回头</a></p>
                                <p>
                                    <a href="#" class="author">申仙</a>
                                    评论<a href="#" class="assess-book-name">候鸟的勇敢</a>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                </p>
                                <p style="color: #000;">
                                    每年从北方飞到南方，再从南方飞回北方，一年要行经多少公里我不知道，一路上要停靠在哪一个地方略作小憩我也不知道，可我知道，无论是遇到台风还是暴雨，每年的这个时候，它们都会飞回来，只要你愿意等，就一定...
                                    <a href="#">(全文)</a>
                                </p>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 1rem;border-bottom: 1px solid #EAEAEA;">
                            <div class="col-2">
                                <img    src="assets/img/2.jpg" class="img-fluid">
                            </div>
                            <div class="col-10 assess">
                                <p><a href="#" class="book-name">此刻不要回头</a></p>
                                <p>
                                    <a href="#" class="author">申仙</a>
                                    评论<a href="#" class="assess-book-name">候鸟的勇敢</a>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                </p>
                                <p style="color: #000;">
                                    每年从北方飞到南方，再从南方飞回北方，一年要行经多少公里我不知道，一路上要停靠在哪一个地方略作小憩我也不知道，可我知道，无论是遇到台风还是暴雨，每年的这个时候，它们都会飞回来，只要你愿意等，就一定...
                                    <a href="#">(全文)</a>
                                </p>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 1rem;border-bottom: 1px solid #EAEAEA;">
                            <div class="col-2">
                                <img src="assets/img/2.jpg" class="img-fluid">
                            </div>
                            <div class="col-10 assess">
                                <p><a href="#" class="book-name">此刻不要回头</a></p>
                                <p>
                                    <a href="#" class="author">申仙</a>
                                    评论<a href="#" class="assess-book-name">候鸟的勇敢</a>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                </p>
                                <p style="color: #000;">
                                    每年从北方飞到南方，再从南方飞回北方，一年要行经多少公里我不知道，一路上要停靠在哪一个地方略作小憩我也不知道，可我知道，无论是遇到台风还是暴雨，每年的这个时候，它们都会飞回来，只要你愿意等，就一定...
                                    <a href="#">(全文)</a>
                                </p>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <div class="col-4">
                <h2 class="head">
                    <span class="new-book">热门标签</span>
                </h2>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">文学</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">小说</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">随笔</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">日本文学</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">散文</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">诗歌</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">童话</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">名著</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">港台</a>
                        </li>

                    </ul>
                </div>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">流行</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">漫画</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">推理</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">绘本</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">青春</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">言情</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">奇幻</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">武侠</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">文化</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">历史</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">哲学</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">传记</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">设计</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">建筑</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">电影</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">回忆录</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">音乐</a>
                        </li>

                    </ul>
                </div>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">生活</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">旅行</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">励志</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">职场</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">教育</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">美食</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">灵修</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">健康</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">家居</a>
                        </li>

                    </ul>
                </div>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">经营</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">经济学</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">管理</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">商业</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">金融</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">营销</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">理财</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">股票</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">历史</a>
                        </li>

                    </ul>
                </div>
                <div class="row">
                    <p style="padding: 0.5rem 0.8rem;margin: 0;">科技</p>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">科普</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">互联网</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">编程</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">交互设计</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">算法</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">通信</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-overrite" href="#">神经网络</a>
                        </li>
                    </ul>
                </div>
                <h2 class="head">
                    <span class="new-book">畅销图书榜</span>
                </h2>
                <div class="sell-well-book">
                    <ul class="ul-nav">
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>
                        <li class="ul-nav-item">
                            <a href="#">浮生六记</a>
                            <p class="author">日]莳田晋治 作/[日]长谷川知子 绘</p>
                        </li>

                    </ul>
                </div>
                <h2 class="head">
                    <span class="new-book">豆瓣图书250</span>
                </h2>
                <div class="row">
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card card-overrite">
                            <img src="assets/img/2.jpg" class="img-fluid">
                            <div class="row" style="margin-top: 1rem;">
                                <div class="col-12">
                                    <a href="#">此刻不要回头</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="bg-light" style="margin-top: 5rem;margin-bottom: 2rem;">
    <div class="container">
        页脚
    </div>
</div>
</body>
</html>
