$(document).ready(function () {
    $('.update-pass').click(function () {
        var flag = true;
        var user = $('#dropdownMenuLink').html();
        var now_pass = $('#nowPass').val();
        var new_pass = $('#newPass').val();
        var surePass = $('#surePass').val();
        console.log(user);
        if (!now_pass) {
            $('.now-pass').removeClass('none').html('当前密码不能为空');
            flag = false;
        }
        if (!new_pass) {
            $('.new-pass').removeClass('none').html('新密码不能为空');
            flag = false;
        }
        if (!surePass) {
            $('.sure-pass').removeClass('none').html('确认新密码不能为空');
            flag = false;
        }

        if (new_pass != surePass) {
            $('.sure-pass').removeClass('none').html('两次输入的密码不相同');
            flag = false;
        }
        console.log(666)
        if (flag) {
            $.ajax({
                type: "post",
                url: "adminUpdataPass",
                data: {
                    user: user,
                    now_pass: now_pass,
                    new_pass: new_pass
                },
                success: function (data) {
                    alert(data);
                }
            })
        }
    });

    $("#nowPass").keypress(function(){
        $(".now-pass").addClass('none');
    });
    $('#newPass').keypress(function () {
        $('.new-pass').addClass('none');
    });

    $('#surePass').keypress(function () {
        $('.sure-pass').addClass('none');
    })
    


})