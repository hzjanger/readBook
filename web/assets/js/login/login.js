function check(form) {
    ttt = form.username.value;
    var flag = true;
    if (form.username.value == '') {
        $('.check-username').removeClass('display').html('用户名不能为空');
        flag = false;
    }
    if (form.password.value == '') {
        $('.check-password').removeClass('display').html('密码不能为空');
        flag = false;
    }
    show();
    return false;

}

$(document).ready(function(){
    $("#username").keypress(function(){
        $(".check-username").addClass('display');
    });
    $('#psw').keypress(function () {
        $('.check-password').addClass('display');
    })
});

function show(){
    console.log(ttt);
}

