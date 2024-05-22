<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录/注册</title>
    <link rel="stylesheet" href="./font_mw3z7ts489g/iconfont.css">
  <link rel="stylesheet" href="css/login.css">
  </head>
  <script  type="text/javascript">
  </script>
  <body>
   <div class="shell">
        <div class="container a-container" id="a-container">
            <form action="SignupServlet" method="post" class="form" id="a-form">
                <h2 class="form_title title">创建账号</h2>
                <div class="form_icons">
                    <i class="iconfont icon-QQ"></i>
                    <i class="iconfont icon-weixin"></i>
                    <i class="iconfont icon-bilibili-line"></i>
                </div>
                <span class="form_span">选择注册方式活电子邮箱注册</span>
                <input type="text" class="form_input" placeholder="Name">
                <input type="text" class="form_input" placeholder="Email">
                <input type="text" class="form_input" placeholder="Password">
                <input type="submit" class="form_button button" value="SIGN UP">
            </form>
        </div>

        <div class="container b-container" id="b-container">
           <form action="LoginServlet" method="post" class="form" id="b-form">
                <h2 class="form_title title">登入账号 </h2>
                <div class="form_icons">
                    <i class="iconfont icon-QQ"></i>
                    <i class="iconfont icon-weixin"></i>
                    <i class="iconfont icon-bilibili-line"></i>
                </div>
                <span class="form_span">选择登录方式活账号登录</span>
                <input type="text" class="form_input" id="usercode" name="usercode" placeholder="username">
                <input type="password" class="form_input" id="password" name="password" placeholder="Password">
                <input type="text" class="form_input" id="code" name="code" placeholder="验证码">
                <div ><img src="<%= request.getContextPath() %>/code" alt="验证码"></div>
                <input type="submit" class="form_button button" value="SIGN IN">
            </form>
            
        </div>

        <div class="switch" id="switch-cnt">
            <div class="switch_circle"></div>
            <div class="switch_circle switch_circle-t"></div>
            <div class="switch_container" id="switch-c1">
                <h2 class="switch_title title" style="letter-spacing: 0;">欢迎回来！</h2>
                <p class="switch_description description">已经有账号了嘛，去登入账号来管理猫咪吧！！！</p>
                <button class="switch_button button switch-btn">SIGN IN</button>
            </div>

            <div class="switch_container is-hidden" id="switch-c2">
                <h2 class="switch_title title" style="letter-spacing: 0;">你好！</h2>
                <p class="switch_description description">去注册一个账号，成为一个猫咪保护者，让我们踏入奇妙的旅途！</p>
                <button class="switch_button button switch-btn">SIGN UP</button>
            </div>
        </div>
    </div>
  </body>
  <script>
    let switchCtn = document.querySelector("#switch-cnt");
    let switchC1 = document.querySelector("#switch-c1");
    let switchC2 = document.querySelector("#switch-c2");
    let switchCircle = document.querySelectorAll(".switch_circle");
    let switchBtn = document.querySelectorAll(".switch-btn");
    let aContainer = document.querySelector("#a-container");
    let bContainer = document.querySelector("#b-container");
    let allButtons = document.querySelectorAll(".submit");

    let getButtons = (e) => e.preventDefault()
    let changeForm = (e) => {
        // 修改类名
        switchCtn.classList.add("is-gx");
        setTimeout(function () {
            switchCtn.classList.remove("is-gx");
        }, 1500)
        switchCtn.classList.toggle("is-txr");
        switchCircle[0].classList.toggle("is-txr");
        switchCircle[1].classList.toggle("is-txr");

        switchC1.classList.toggle("is-hidden");
        switchC2.classList.toggle("is-hidden");
        aContainer.classList.toggle("is-txl");
        bContainer.classList.toggle("is-txl");
        bContainer.classList.toggle("is-z");
    }
    // 点击切换
    let shell = (e) => {
        for (var i = 0; i < allButtons.length; i++)
            allButtons[i].addEventListener("click", getButtons);
        for (var i = 0; i < switchBtn.length; i++)
            switchBtn[i].addEventListener("click", changeForm)
    }
    window.addEventListener("load", shell);

</script>
</html>

