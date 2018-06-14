$(document).ready(function () {
    $('.onSubmit').click(function () {
        var img_url = $('.book-info-form .img-fluid').attr("src");
        var ISBN = $('input[name="ISBN"]').val();
        var book_name = $('input[name="book_name"]').val();
        var publish_time = $('input[name="publish_time"]').val();
        var publiseer = $('input[name="publiseer"]').val();
        var author = $('input[name="author"]').val();
        var tranaslators = $('input[name="tranaslators"]').val();
        var price = $('input[name="price"]').val();
        var binding = $('input[name="binding"]').val();
        var page_amount = $('input[name="page_amount"]').val();
        var type = $('input[name="type"]').val();
        var content_introduce = $('#content-introduce').val();
        var author_introduce = $('#author-introduce').val();
        var directory = $('#directory').val();

        $.ajax({
            type: "post",//请求方式
            url: "insetBook",//发送请求地址
            timeout: 30000,//超时时间：30秒,
            data: {
                img_url: img_url,
                ISBN: ISBN,
                book_name: book_name,
                publish_time: publish_time,
                publiseer: publiseer,
                author: author,
                tranaslators: tranaslators,
                price: price,
                binding: binding,
                page_amount: page_amount,
                type: type,
                content_introduce: content_introduce,
                author_introduce: author_introduce,
                directory: directory
            },
            // dataType: "json",//设置返回数据的格式
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                alert(data);
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        });
    });
    
    $('.auto-write').click(function () {
        var url = $('input[name="url"]').val();
        $.ajax({
            type: "get",//请求方式
            url: "insetBook",//发送请求地址
            timeout: 30000,//超时时间：30秒,
            data: {
                url: url
            },
            dataType: "json",//设置返回数据的格式
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                $.each(data,function(key,value) {
                    if (key == 'book_img') {
                        $('.book-info-form .img-fluid').attr("src",value);
                    }
                    if (key == 'ISBN') {
                        $('input[name="ISBN"]').val(value);
                    }
                    if (key == 'putlish_time') {
                        $('input[name="publish_time"]').val(value);
                    }
                    if (key == 'book_name') {
                        $('input[name="book_name"]').val(value);
                    }
                    if (key == 'publiseer') {
                        $('input[name="publiseer"]').val(value);
                    }
                    if (key == 'author') {
                        $('input[name="author"]').val(value);
                    }
                    if (key == 'translators') {
                        $('input[name="tranaslators"]').val(value);
                    }
                    if (key == 'price') {
                        $('input[name="price"]').val(value);
                    }
                    if (key == 'binding') {
                        $('input[name="binding"]').val(value);
                    }
                    if (key == 'page_amount') {
                        $('input[name="page_amount"]').val(value);
                    }
                    if (key == 'content_Introduction') {
                        $('#content-introduce').val(value);
                    }
                    if (key == 'directory') {
                        $('#directory').val(value);
                    }
                });
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        });
    })

});