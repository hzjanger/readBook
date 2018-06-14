$(document).ready(function() {
    $('#userName').blur(function() {
        $.ajax({
            url : 'test',
            data : {
                userName : $('#userName').val()
            },
            success : function(responseText) {
                console.log(responseText)
                // $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});



// ISBN: ISBN,
// book_name: book_name,
// publish_time: publish_time,
// publiseer: publiseer,
// author: author,
// translators: tranaslators,
// price: price,
// binding: binding,
// page_amount: page_amount,
// type: type,
// content_introduce: content_introduce,
// author_introduce: author_introduce,
// directory: directory