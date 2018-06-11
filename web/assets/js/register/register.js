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
//
// var http_request = false;
// function createRequest(url) {
//     http_request = false;
//     if (window.XMLHttpRequest) {
//         http_request = new XMLHttpRequest();
//         if (http_request.overrideMimeType) {
//             http_request.overrideMimeType('text/xml');
//         }
//
//     } else if (window.ActiveXObject) {
//         try{
//             http_request = new ActiveXObject('Msxml2.XMLHTTP');
//         } catch (e) {
//             try {
//                 http_request = new ActiveXObject('Micorosoft.XMLHTTP');
//             } catch (e) {
//
//             }
//         }
//
//         if (!http_request) {
//             alert('不能创建XMLHttpResquest对象实例');
//             return false;
//         }
//         http_request.onreadystatechange = getResult;
//         http_request.open('POST', url, True);
//         http_request.setRequestHeader("Content-Type", 'application/x-www-form-urlencoded');
//         var formData = '';
//         var elem = '';
//         for (var i = 0; i < form1.elementnts.length; i++) {
//
//         }
//
//
//     }
// }