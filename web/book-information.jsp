<%--
  Created by IntelliJ IDEA.
  User: hzj
  Date: 18-6-2
  Time: 上午9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap-4.0.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/base/base.css">
    <link rel="stylesheet" href="assets/css/book-information/information.css">
    <link rel="stylesheet" href="assets/css/book-information/review.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<%--头部信息--%>
<div class="bg-light">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <nav class="navbar navbar-expand-sm">
                    <a class="navbar-brand" href="#">豆瓣读书</a>
                </nav>
            </div>
            <div class="col-6">
                <form>
                    <input type="text" class="form-control form-control-overrite" id="usr">
                    <button type="submit" class="btn btn-primary search-button">搜索</button>
                </form>
            </div>
            <div class="col-4">
                <ul class="nav text-dark justify-content-end nav-overrite">
                    <li class="nav-item">
                        <a class="nav-link" href="#">登录</a>
                    </li>
                    <li class="head-line">
                        <span class="nav-line">|</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">免费注册</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="bg-light" style="border-top: 1px solid #E9E9E2;">
    <div class="container" >
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#">购书单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">电子图书</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">豆瓣书店</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">2017年度榜单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">2017读书报告</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">购物车</a>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <h2 class="book-name">此刻不要回头</h2>
    <div class="row book-information">
        <div class="col-2">
            <img src="assets/img/2.jpg" alt="图书" class="img-fluid">
        </div>
        <div class="col-7">
            <p>作者: <a href="#" class="author">[英]达芙妮·杜穆里埃</a></p>
            <p>出版社: <span>江苏凤凰文艺出版社</span></p>
            <p>原作名: <span>Don’t Look Now and Other Stories</span></p>
            <p>  译者: <a href="#">余大卫</a></p>
            <p>出版年: <span>2018-6-2</span></p>
            <p>  页数: <span>666</span></p>
            <p>  装帧: <span>平装</span></p>
            <p>  丛书: <span>达芙妮·杜穆里埃作品</span></p>
            <p>  ISBN: <span>9787559417862</span></p>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-12">
            <p class="introduction">内容简介  · · · · · · </p>
        </div>
        <div class="col-12 introduction-container">
            <p>◆20世纪殿堂级文学大师的悬疑经典！</p>
            <p>◆荣获爱伦·坡奖和美国国家图书奖的文坛巨匠</p>
            <p>◆英国大师级作家、英国皇家文学会会员！</p>
            <p>◆经典名著《蝴蝶梦》《浮生梦》作者</p>
            <p>◆达芙妮·杜穆里埃首部短篇悬疑小说集</p>
            <p>◆听我的，不要回头！不要回头！</p>
            <p>********************************</p>
            <p>“此刻不要回头。”</p>
            <p>威尼斯的一家餐厅内，约翰警告妻子劳拉。</p>
            <p>但随着劳拉的那次回头，一切随之改变。后来——</p>
            <p>劳拉结识了一对自称能看见亡魂的双胞胎姐妹，丈夫约翰却认为这对双胞胎姐妹不怀好意。</p>
            <p>约翰在小巷里发现了一个拼命逃跑的红色小女孩身影，妻子劳拉却什么也没瞧见。</p>
            <p>与此同时，威尼斯逐渐被死亡的阴影笼罩，所有人都在讨论一起连环杀人案件。警方从中看不出任何动机，凶手迟迟没有归案，而约翰和劳拉对此还一无所知......</p>
        </div>
        <div class="col-12">
            <p class="introduction">作者简介  · · · · · · </p>
        </div>
        <div class="col-12 introduction-container">
            <p>达芙妮·杜穆里埃（1907-1989）</p>
            <p>Daphne du Maurier</p>
            <p>达芙妮·杜穆里埃，英国当代极具影响力的殿堂级女作家，英国皇家文学会会员，曾获爱伦·坡大师奖、美国国家图书奖和安东尼世纪图书奖。</p>
            <p>杜穆里埃一生共创作17部长篇以及几十种其他体裁的文学作品，被誉为“打破通俗小说与纯文学界限”的大师级作家，1938年出版的成名作《蝴蝶梦》基至影响了一个时代情感小说的走向。</p>
            <p>《此刻不要回头》是达芙妮·杜穆里埃为数不多的短篇佳作集，由五个短篇故事组成，在满足大众阅读需求的同时也具有很高的文学性。根据第一个短篇《此刻不要回头》改编而来的电影，自上映之后斩获诸多重磅电影大奖。</p>

        </div>
        <div class="col-12">
            <p class="introduction">目录  · · · · · · </p>
        </div>
        <div class="col-12 introduction-container">
            <p>此刻不要回头 / 001</p>
            <p>不要在午夜以后 / 061</p>
            <p>边界内外 / 113</p>
            <p>十字架之路 / 192</p>
            <p>突破 / 271</p>

        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <p class="introduction">此刻不要回头的书评 · · · · · · ( 全部 3 条 )</p>
        </div>
        <div class="col-12 review-value">
            <img src="assets/img/3.jpg" class="img-fluid">
            <a href="#" class="user">马上有腹肌的帅</a>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star-half-o" aria-hidden="true"></i>
            <span class="review-time">2018-05-30</span>
            <p class="review-title"><a href="#">极具可读性的短片悬疑集</a></p>
            <p>这部短篇里的五个故事中，每个故事都有令人惊讶的结局。
                但它既没有通常悬疑小说所具备的反转，也没有烧脑的剧情设定，可你就是猜不中结尾到底怎样。
                我第一次读时只看懂了开头，却万万没有猜中竟是这样的结尾，以至于每次看到结尾时都要再重温一下故事的开头。
                最后才发现，这五个故事的开头与结尾竟完美衔接地犹如一脉倾泻而出的牛奶，丝毫不差，浑然天成。
                你得要把每个故事都看到底，再从头仔仔细细地回味，你才能明白这五个故事从一开始就展现出了它独特的整体性、从头到尾的悬疑性以及通篇干净利落的文字叙述！
                我花了一个晚上就看完了这五个故事，却感觉自己好像连续看了整整五部电影。
                </p>
        </div>
        <div class="col-12 review-value">
            <img src="assets/img/3.jpg" class="img-fluid">
            <a href="#" class="user">马上有腹肌的帅</a>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star-half-o" aria-hidden="true"></i>
            <span class="review-time">2018-05-30</span>
            <p class="review-title"><a href="#">极具可读性的短片悬疑集</a></p>
            <p>这部短篇里的五个故事中，每个故事都有令人惊讶的结局。
                但它既没有通常悬疑小说所具备的反转，也没有烧脑的剧情设定，可你就是猜不中结尾到底怎样。
                我第一次读时只看懂了开头，却万万没有猜中竟是这样的结尾，以至于每次看到结尾时都要再重温一下故事的开头。
                最后才发现，这五个故事的开头与结尾竟完美衔接地犹如一脉倾泻而出的牛奶，丝毫不差，浑然天成。
                你得要把每个故事都看到底，再从头仔仔细细地回味，你才能明白这五个故事从一开始就展现出了它独特的整体性、从头到尾的悬疑性以及通篇干净利落的文字叙述！
                我花了一个晚上就看完了这五个故事，却感觉自己好像连续看了整整五部电影。
            </p>
        </div>
        <div class="col-12 review-value">
            <img src="assets/img/3.jpg" class="img-fluid">
            <a href="#" class="user">马上有腹肌的帅</a>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star-half-o" aria-hidden="true"></i>
            <span class="review-time">2018-05-30</span>
            <p class="review-title"><a href="#">极具可读性的短片悬疑集</a></p>
            <p>这部短篇里的五个故事中，每个故事都有令人惊讶的结局。
                但它既没有通常悬疑小说所具备的反转，也没有烧脑的剧情设定，可你就是猜不中结尾到底怎样。
                我第一次读时只看懂了开头，却万万没有猜中竟是这样的结尾，以至于每次看到结尾时都要再重温一下故事的开头。
                最后才发现，这五个故事的开头与结尾竟完美衔接地犹如一脉倾泻而出的牛奶，丝毫不差，浑然天成。
                你得要把每个故事都看到底，再从头仔仔细细地回味，你才能明白这五个故事从一开始就展现出了它独特的整体性、从头到尾的悬疑性以及通篇干净利落的文字叙述！
                我花了一个晚上就看完了这五个故事，却感觉自己好像连续看了整整五部电影。
            </p>
        </div>
    </div>
</div>
<div class="bg-light" style="margin-top: 2rem;margin-bottom: 2rem;">
    <div class="container">
        页脚
    </div>
</div>
</body>
</html>
