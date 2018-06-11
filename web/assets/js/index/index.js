function show() {
    // $('#userName').blur(function() {
    //     $.ajax({
    //         url : 'showIndex',
    //         data : {
    //             userName : $('#userName').val()
    //         },
    //         success : function(responseText) {
    //             console.log(responseText)
    //             // $('#ajaxGetUserServletResponse').text(responseText);
    //         }
    //     });
    // });
    $.ajax({
        type: 'post',
        url : 'showIndex',
        data : {
            userName : ""
        },
        // success : function(responseText) {
        //     console.log(responseText[0].ISBN)
        //     console.log(responseText)
        //     // $('#ajaxGetUserServletResponse').text(responseText);
        // }
    })
}