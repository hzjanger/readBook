function check(form) {
    var flag = true;
    if (form.user.value == '') {
        $('.check-user').removeClass('display').html('昵称不能为空');
        flag = false;
    }
    if (form.email.value == '') {
        $('.check-email').removeClass('display').html('邮箱不能为空');
        flag = false;
    }

    if (form.pass.value == '') {
        $('.check-pass').removeClass('display').html('密码不能为空');
        flag = false;
    }

    if (form.passsure.value == '') {
        $('.check-passsure').removeClass('display').html('确认密码不能为空');
        flag = false;
    }

    if (form.pass.value != form.passsure.value) {
        $('.check-passsure').removeClass('display').html('两次输入的密码不同');
        flag = false;
    }
    return flag;
}

$(document).ready(function(){
    $("#username").keypress(function(){
        $(".check-user").addClass('display');
    });

    $('#email').keypress(function () {
        $(".check-email").addClass('display');
    });
    $('#psw').keypress(function () {
        $('.check-pass').addClass('display');
    });
    $('#repsw').keypress(function () {
        $('.check-passsure').addClass('display');
    })
});