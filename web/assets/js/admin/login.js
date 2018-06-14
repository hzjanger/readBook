// function check(form) {
//     ttt = form.username.value;
//     var flag = true;
//     if (form.username.value == '') {
//         $('.check-username').removeClass('display').html('用户名不能为空');
//         flag = false;
//     }
//     if (form.password.value == '') {
//         $('.check-password').removeClass('display').html('密码不能为空');
//         flag = false;
//     }
//     return flag;
//
// }

$(document).ready(function(){

    $('.login').click(function () {
        var flag = true;
        var user = $('input[name="username"]').val();
        var pass = $('input[name="password"]').val();
        if (user == '') {
            $('.check-username').removeClass('display').html('用户名不能为空');
            flag = false;
        }
        if (pass == '') {
            $('.check-password').removeClass('display').html('密码不能为空');
            flag = false;
        }

        if (flag) {
            $.ajax({
                type: "post",
                url: "adminLogin",
                data: {
                    user: user,
                    pass: pass
                },
                // dataType: "json",
                success: function (data) {
                    if (data == "success") {
                        window.location.href='../../../adminIndex.jsp';
                    } else {
                        alert("用户名或密码错误");
                    }


                },
                error: function () {
                    alert("请求失败")
                }
            })
        }


    })
    $("#username").keypress(function(){
        $(".check-username").addClass('display');
    });
    $('#psw').keypress(function () {
        $('.check-password').addClass('display');
    })
});


