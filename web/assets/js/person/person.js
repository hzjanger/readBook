$(document).ready(function () {
    $("#img_input").bind('change',function(){
        var fordate=new FormData();
        var fils=$("#img_input").get(0).files[0];
        fordate.append('pic',fils);
        var srcc=window.URL.createObjectURL(fils);
        console.log(srcc);
        $(".img-fluid").attr('src',srcc);
    });

    $('.save-information').click(function () {
        var user_img = $('.person-img img.rounded-circle').attr("src");
        var old_user_name = $('#dropdownMenuLink').text();
        var flag = true;
        var user_name = $('#user-name').val();
        if (user_name == "") {
            $('.check-user-name').removeClass('display').html("昵称不能为空");
            flag = false;
        }

        var birth = $('#birth').val();
        var email = $('#user-email').val();
        if (email == '') {
            $('.check-email').removeClass('display').html("邮箱不能为空");
            flag = false;
        }

        console.log(111)
        var sex = $('#exampleFormControlSelect1').val();
        if (flag) {
            console.log("Jin")
            $.ajax({
                type: "get",
                url: "saveUserInfro",
                tiemout: 3000,
                data: {
                    old_user_name: old_user_name,
                    user_name: user_name,
                    email: email,
                    user_img: user_img,
                    birth: birth,
                    sex: sex
                },
                success: function (data) {
                    alert(data)
                },
                error: function () {
                    alert("请求出错");
                }
            })
        }
    });
    $('.person-center').click(function () {
        var user = $('#dropdownMenuLink').text();
        console.log(user)
        $.ajax({
            type: "post",
            url: "personCenter",
            timeout: 3000,
            data: {
                user: user
            },
            dataType: "json",
            success: function (data) {
                window.location.href="../../../person.jsp";
                $.each(data, function (key, value) {
                    if (key == "user_name") {
                        $('#user-name').value = value;
                    }
                })
                console.log(data);

            },
            error: function () {

            }
        })
    })
})

function show() {
    alert(123);
}