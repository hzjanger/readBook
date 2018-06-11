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
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-12">
        <form>
            <input type="text" class="form-control form-control-overrite" placeholder="书籍名称">
            <button type="submit" class="btn btn-primary search-button">搜索</button>
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
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">BSIN</th>
                    <th scope="col">书籍名称</th>
                    <th scope="col">评分</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>9787020131624</td>
                    <td>最后一公里的哲学：电商物流全链条运营管理</td>
                    <td>暂无</td>
                    <td><a href="#">删除</a></td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>9787020131624</td>
                    <td>最后一公里的哲学：电商物流全链条运营管理</td>
                    <td>暂无</td>
                    <td><a href="#">删除</a></td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>9787020131624</td>
                    <td>最后一公里的哲学：电商物流全链条运营管理</td>
                    <td>暂无</td>
                    <td><a href="#">删除</a></td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>9787020131624</td>
                    <td>最后一公里的哲学：电商物流全链条运营管理</td>
                    <td>暂无</td>
                    <td><a href="#">删除</a></td>
                </tr>
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
