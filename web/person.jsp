<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-14
  Time: 上午10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/base/base.css">
    <link rel="stylesheet" href="assets/css/person/person.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user_info");
    if (user == null) {
        user.init();
    }
    System.out.println(user.getBirth());
    if ("".equals(user.getBirth())) {
        user.setBirth("出生日期(格式为： 年-月-日)");
    }
    System.out.println("user = "+user);
%>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<div class="container" style="margin-top: 1rem">
    <div class="row">
        <div class="col-2">
            <div class="row bg-light">
                <div class="col-12 person-img">
                    <img src="<%=user.getUser_img()%>" class="img-fluid rounded-circle">
                    <input class="input-none" id="img_input" type="file"/>
                    <label for="img_input" id="choice-img" class="btn btn-primary btn-block" style="margin-top: 1rem;">更换头像</label>
                </div>
                <div class="col-12">
                    <h5 style="margin: 1rem 0 1rem 0;">账户管理</h5>
                </div>
                <div class="col-12 person-nav">
                    <ul class="nav flex-column">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">个人信息</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-10">
            <div class="row">
                <div class="col-12">
                   <div class="information">
                       <h5>个人信息</h5>
                   </div>
                </div>
                <div class="col-12">
                    <div class="information-box">
                        <form>
                            <div class="form-group">
                                <label for="user-name">昵称: </label>
                                <input type="text" class="form-control" id="user-name" aria-describedby="emailHelp" placeholder="<%=user.getUser_name()%>">
                                <div class="alert alert-danger alert-dismissable fade show display check-user-name"></div>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">性别: </label>
                                <select class="form-control" id="exampleFormControlSelect1">
                                    <option>男</option>
                                    <option>女</option>
                                    <option>保密</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="birth">出生日期: </label>
                                <input type="text" class="form-control" id="birth" aria-describedby="emailHelp" placeholder="<%=user.getBirth()%>">
                            </div>
                            <div class="form-group">
                                <label for="user-email">邮箱: </label>
                                <input type="email" class="form-control" id="user-email" aria-describedby="emailHelp" placeholder="<%=user.getUser_email()%>">
                                <div class="alert alert-danger alert-dismissable fade show display check-email"></div>
                            </div>
                           <div>
                               <button type="button" class="btn btn-primary save-information">保存信息</button>
                           </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
