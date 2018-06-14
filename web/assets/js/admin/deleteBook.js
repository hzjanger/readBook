$(document).ready(function () {
   $('.serach-delete-book').click(function () {
       var value = $('.form-delete-book').val();
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
               $('.table-delete-book').empty();
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
                   $('.table-delete-book').append(
                       '<tr class="'+ISBN+'"><th scope="row">'+i+'</th>' +
                       '<td>' + ISBN + '</td>' +
                       '<td>' + book_name + '</td>' +
                       '<td>' + review_grade + '</td>' +
                       '<td><span class="delete" onclick="delete_Book('+""+ISBN+')">删除</span></td>');

               })
           },
           error: function () {
               alert("请求失败")
           }
       })
   });

});

function delete_Book(ISBN) {
    $.ajax({
        type: "get",
        url: "deleteBook",
        timeout: 3000,
        data: {
            ISBN: ISBN
        },
        // dataType: "json",
        success: function (data) {
            alert(data)
            $('tr.'+ISBN).empty()
        },
        error: function () {
            alert("请求失败");
        }
    })
}