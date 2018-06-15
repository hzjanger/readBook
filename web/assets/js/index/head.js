$(document).ready(function () {
    $('.nav-img').click(function () {
        if ($('.menu-nav').hasClass('none')) {
            $('.menu-nav').removeClass('none');
        } else {
            $('.menu-nav').addClass('none');
        }

    })

    $(document).bind('click', function(e) {
        var e = e || window.event; //浏览器兼容性
        var elem = e.target || e.srcElement;
        while (elem) { //循环判断至跟节点，防止点击的是div子元素
            if (elem.id && elem.id == 'head-img') {
                return;
            }
            elem = elem.parentNode;
        }
        $('.menu-nav').addClass('none'); //点击的不是div或其子元素

    });

})