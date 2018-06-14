$(document).ready(function () {
    $('.search-change').click(function () {
        var value = $('input[name="change"]').val();
        console.log(value);
        $.ajax({
            type: "get",
            url: "search",
            timeout: 3000,
            data: {
                key: value,
                type: "delete"
            },
            dataType: "json",
            success: function (data) {
                if (data.length == 0) {
                    alert("此书不存在");
                    return;
                }
                console.log(data.length)
                var i = 0;
                $('.table-change-book').empty();
                $.each(data, function (key, value) {

                    var ISBN, book_name, review_grade='暂无评价';
                    $.each(value, function (key1, value1) {
                        if (key1 == "ISBN") {
                            ISBN = value1;
                        }
                        if (key1 == "book_name") {
                            book_name = value1;
                        }
                        if (key1 == "review_grade") {
                            review_grade = value1;
                        }
                    });
                    i++;
                    console.log(i);
                    $('.table-change-book').append(
                        '<tr class="'+ISBN+'"><th scope="row">'+i+'</th>' +
                        '<td>' + ISBN + '</td>' +
                        '<td>' + book_name + '</td>' +
                        '<td>' + review_grade + '</td>' +
                        '<td><span class="delete" onclick="change_book('+""+ISBN+')">修改</span></td>');

                })
            },
            error: function () {
                alert("请求失败")
            }
        })
    });
    $('.updata-submit').click(function () {
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
            url: "updataBook",//发送请求地址
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
        })
    })





})

function change_book(ISBN) {
    $.ajax({
        type: "get",
        url: "updataBook",
        timeout: 3000,
        data: {
            ISBN: ISBN
        },
        dataType: "json",
        success: function (data) {
            $.each(data, function (key, value) {
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
            })
            $('.container-fluid div.show').removeClass('show').addClass('none');
            $($('.container-fluid div.bg-light')[0]).addClass('show');
            $('.updata-submit').removeClass('none').addClass('show');
            $('.onSubmit').removeClass('show').addClass('none');
            $('.auto-form').removeClass('show').addClass('none');

        },
        error: function () {
            alert("请求失败");
        }
    })

}