<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-9
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-12">
        <form action="/insetBook" method="post">
            <input type="text" class="form-control form-control-overrite" id="usr" name="url" placeholder="输入豆瓣读书上的网址">
            <button type="submit" class="btn btn-primary search-button">自动填充</button>
        </form>
    </div>
</div>

<form class="book-info-form">
    <div class="row">
        <div class="col-3">
            <img src="https://img3.doubanio.com/view/subject/l/public/s29767862.jpg" referrerpolicy ="never" alt="图书" class="img-fluid">
            <input class="input-none" id="img_input" type="file" accept="image/*"/>
            <label for="img_input" id="choice-img" class="btn btn-primary btn-block" style="margin-top: 1rem;">更换图片</label>
        </div>
        <div class="col-9">
            <div class="row">
                <div class="col-12">
                    <span class="book-info">书号: </span><input type="text" class="form-control form-control-book-information" placeholder="书号">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">书名: </span><input type="text" class="form-control form-control-book-information" placeholder="书名">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">出版年: </span><input type="text" class="form-control form-control-book-information" placeholder="出版年">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">出版社: </span><input type="text" class="form-control form-control-book-information" placeholder="出版社">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">作者: </span><input type="text" class="form-control form-control-book-information" placeholder="作者">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">译者: </span><input type="text" class="form-control form-control-book-information" placeholder="译者">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">价格: </span><input type="text" class="form-control form-control-book-information" placeholder="价格">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">装帧类型: </span><input type="text" class="form-control form-control-book-information" placeholder="装帧类型">

                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <span class="book-info">页数: </span><input type="text" class="form-control form-control-book-information" placeholder="页数">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <p class="introduction"></p>
            <div class="form-group">
                <label for="content-introduce">内容简介  · · · · · · </label>
                <textarea class="form-control" id="content-introduce" rows="6"></textarea>
            </div>
        </div>
        <div class="col-12 introduction-container">
            <%--动态的渲染书籍的内容简介--%>
        </div>

        <div class="col-12">
            <div class="form-group">
                <label for="author-introduce">作者简介  · · · · · · </label>
                <textarea class="form-control" id="author-introduce" rows="6"></textarea>
            </div>
        </div>
        <div class="col-12">
            <div class="form-group">
                <label for="directory">目录  · · · · · · </label>
                <textarea class="form-control" id="directory" rows="6"></textarea>
            </div>
        </div>
    </div>
    <div class="row">
        <button type="submit" class="btn btn-primary" style="margin: auto;">保存书籍</button>
    </div>
</form>
</body>
</html>
