<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-13
  Time: 下午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 5rem;">
        <div class="col-2"></div>
        <div class="col-8">
            <form>
                <div class="form-group">
                    <label for="nowPass">当前密码:</label>
                    <input type="text" class="form-control" id="nowPass" aria-describedby="emailHelp" placeholder="当前密码">
                    <div class="alert alert-danger now-pass none" role="alert"></div>
                </div>
                <div class="form-group">
                    <label for="newPass">新密码:</label>
                    <input type="password" class="form-control" id="newPass" aria-describedby="emailHelp" placeholder="新密码">
                    <div class="alert alert-danger new-pass none" role="alert"></div>
                </div>

                <div class="form-group">
                    <label for="surePass">确认新密码:</label>
                    <input type="password" class="form-control" id="surePass" aria-describedby="emailHelp" placeholder="确认新密码">
                    <div class="alert alert-danger sure-pass none" role="alert"></div>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary update-pass">确认修改密码</button>
                </div>
            </form>
        </div>
        <div class="col-2"></div>
    </div>
</div>

</body>
</html>
