$(document).ready(function () {

    $(".choice-img").on("change", function(){

        // $.ajax({
        //     url: "/choiceFile",
        //     type: "get",
        //     timeout: "50000",
        //     success:function(data){
        //         alert("请求成功");
        //
        //         // $("#resultJsonText").text("你的名字："+data.yourName+"  你输入的内容:"+data.yourContent);
        //     },
        //
        // })
        console.log(123);


        // var file = e.target.files[0];
        // if (!file.type.match('image.*')) {
        //     return false;
        // }
        // var reader = new FileReader();
        // reader.readAsDataURL(file); // 读取文件
        // // 渲染文件
        // reader.onload = function(arg) {
        //
        //     $('.img-fluid').attr("src", arg.target.result );
        //     console.log($('.img-fluid').html());
        //     // var img = '<img class="preview" src="' + arg.target.result + '" alt="preview"/>';
        //     // $(".preview_box").empty().append(img);
        // }
    });

    $('.nav-item').click(function () {
        $('.left-menu li.active').removeClass('active');
        $(this).addClass('active');
        console.log($(this).text());
        $('.container-fluid div.show').removeClass('show').addClass('none');
        if ($(this).text().indexOf("添加书籍") > -1) {
            $($('.container-fluid div.bg-light')[0]).addClass('show');
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


})

var fileInput = document.getElementById('choice-img');
if (fileInput) {
    console.log(123)
    fileInput.addEventListener('change', function () {
        if (!fileInput.value) {
            info.innerHTML = '没有选择文件';
            return;
        }
    })
}


