<%@ page import="entity.User" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %><%--
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
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var fil=$("#fil");
            $("<img>").insertAfter("input");
            $("#fil").bind('change',function(){
                var fordate=new FormData();
                var fils=$("#fil").get(0).files[0];
                fordate.append('pic',fils);
                var srcc=window.URL.createObjectURL(fils);
                console.log(srcc);
                $(".img-fluid").attr({'src':srcc});


            });
        });
    </script>
</head>
<body>

<input type="file" id="fil">
<img src="https://img3.doubanio.com/view/subject/l/public/s29767862.jpg" referrerpolicy ="never" alt="图书" class="img-fluid">

</body>
</html>
