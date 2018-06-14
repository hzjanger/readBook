$(document).ready(function () {
    $("#img_input").bind('change',function(){
        var fordate=new FormData();
        var fils=$("#img_input").get(0).files[0];
        fordate.append('pic',fils);
        var srcc=window.URL.createObjectURL(fils);
        console.log(srcc);
        $(".img-fluid").attr('src',srcc);
    });
})