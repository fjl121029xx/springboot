<!DOCTYPE html>
<html>

<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hello Boorstrap</title>
</head>
<script>
    $(function(){
        $('#carousel-ad').carousel({
            interval: 3000
        });
    });

</script>
<body>


<div id="demo" class="carousel slide" data-ride="carousel">

    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- 轮播图片 -->
    <div class="carousel-inner slide"  data-ride="carousel" data-interval="10000">

        <div class="carousel-item active">
            <img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg" style="width: 100%;">
            <div class="carousel-caption">
                <h3>第一张图片描述标题</h3>
                <p>描述文字!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://static.runoob.com/images/mix/img_nature_wide.jpg" style="width: 100%;">
            <div class="carousel-caption">
                <h3>第二张图片描述标题</h3>
                <p>描述文字!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg" style="width: 100%;">
            <div class="carousel-caption">
                <h3>第三张图片描述标题</h3>
                <p>描述文字!</p>
            </div>
        </div>
    </div>

    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>

</div>

</body>

</html>