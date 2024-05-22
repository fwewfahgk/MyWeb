<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/update.css">
    <title>信息修改</title>
</head>
<body>
  <div class="shell">
   <div class="container b-container" id="b-container">
           <form action="UpdateServlet" method="post" class="form" id="b-form">
                <h2 class="form_title title">修改账户 </h2>
                <div class="form_icons">
                    <i class="iconfont icon-QQ"></i>
                    <i class="iconfont icon-weixin"></i>
                    <i class="iconfont icon-bilibili-line"></i>
                </div>
                <span class="form_span"></span>
                <input type="text" class="form_input" id="name" name="name" placeholder="请输入新用户名">
               <input type="text" class="form_input" id="pwd" name="pwd" placeholder="请输入新密码">
                <input type="submit" class="form_button button" value="修改">
            </form>
            
        </div>
      </div>
</body>
</html>