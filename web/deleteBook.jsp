<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-9
  Time: 下午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
    <link rel="stylesheet" href="assets/css/admin/deleteBook.css">
</head>
<body>
<div class="row">
    <div class="col-12">
        <form>
            <input type="text" name="key" class="form-control form-control-overrite form-delete-book" placeholder="书籍名称" >
            <button type="button" class="btn btn-primary search-button serach-delete-book">搜索</button>
        </form>
    </div>
</div>
<%--<div class="row">--%>
    <%--<div class="col-12">--%>
        <%--<button class="btn btn-primary">批量删除</button>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="row">
    <div class="col-12">
        <table class="table table-striped ">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">BSIN</th>
                    <th scope="col">书籍名称</th>
                    <th scope="col">评分</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody class="table-delete-book">
            </tbody>
        </table>
    </div>
</div>
<div class="row" style="margin-top: 1rem;margin-bottom: 0rem;">
    <div class="col-12">
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
</body>
</html>
