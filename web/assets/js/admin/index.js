$(document).ready(function () {
    $("#img_input").bind('change',function(){
        var fordate=new FormData();
        var fils=$("#img_input").get(0).files[0];
        fordate.append('pic',fils);
        var srcc=window.URL.createObjectURL(fils);
        console.log(srcc);
        $(".img-fluid").attr('src',srcc);
    });

    $('.left-menu .nav-item').click(function () {
        $('.left-menu li.active').removeClass('active');
        $(this).addClass('active');
        console.log($(this).text());
        $('.container-fluid div.show').removeClass('show').addClass('none');
        if ($(this).text().indexOf("添加书籍") > -1) {
            $($('.container-fluid div.bg-light')[0]).addClass('show');
            console.log("添加书籍add")
            $('.auto-form'  ).removeClass('none').addClass('show');
            $('.onSubmit').removeClass('none').addClass('show');
            $('.updata-submit').removeClass('show').addClass('none');
        }

        if ($(this).text().indexOf("删除书籍") > -1) {
            $($('.container-fluid div.bg-light')[1]).addClass('show');
        }

        if ($(this).text().indexOf("修改书籍") > -1) {
            $($('.container-fluid div.bg-light')[2]).addClass('show');

        }

        if ($(this).text().indexOf("查找书籍") > -1) {
            $($('.container-fluid div.bg-light')[3]).addClass('show');
        }

        if ($(this).text().indexOf("修改密码") > -1) {
            $($('.container-fluid div.bg-light')[4]).addClass('show');
        }
    });
});


