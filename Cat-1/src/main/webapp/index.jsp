<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>流浪猫管理系统</title>
	    <style>
	    </style>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="css/index.css">
		<link rel="stylesheet" href="css/logincard.css">
	</head>
	<body>

	    <div class="container">
	        <h1>欢迎使用流浪猫管理系统</h1>
	        <p id="p1">尊敬的猫咪保护者：<span style="color: orange; font-size: 20px;"> ${user.userName }</span>
	        <br/>
	        账号：${user.userCode}
	        </p>
	        
	        <div class="card-container">
	            <div class="card" onclick="location.href='AddServlet'">
	                <span class="max">
					<h3>猫咪信息删除</h3>
					</span>
	            </div>
	            <div class="card" onclick="location.href='AllCatServlset'">
	                <h3>流浪猫信息</h3>
	            </div>
	            <div class="card" onclick="location.href='update.jsp'">
					<span class="max">
						<h3>账号密码修改</h3>
						</span>
	            </div>
	            <div class="card" onclick="location.href='catcatcat.jsp'">
	                <span class="max">
					<h3>添加猫咪</h3>
					</span>
	            </div>
	        </div>
	        
	
	<div class="lunbo">
		<div class="shell">
			<ul class="images">
				<li class="img"></li>
				<li class="img"></li>
				<li class="img"></li>
				<li class="img"></li>
				<li class="img"></li>
			</ul>
			<ul class="min">
				<li class="m"></li>
				<li class="m"></li>
				<li class="m"></li>
				<li class="m"></li>
				<li class="m"></li>
			</ul>
			<div class="button">
				<div class="button-left">&lt;</div>
				<div class="button-right">&gt;</div>
			</div>
		</div>
	</div>
	<div class="wenzi">
	<div class="box">
	  <div class="card1" style="--color: #0d9545;">
	    <img src="./img/hudie.jpg" alt="猫咪">
	    <div class="text-box">
	      <h2>制作初心</h2>
	      <p>
	        对于流浪猫来说，他们是城市里的孤儿，没人陪伴，也没有温暖的家。随着城市的不断发展，人口增加，流浪猫数量越来越多，但同时也面临着无处可去，饥饿、疾病等各种危险。
<br/>为了解决这些问题，我们决定制作一款流浪猫管理网站，以提供更好的保护和帮助流浪猫为初心。我们深知人与动物之间的关系，认为每一个动物都应该得到必要的保护和关爱。<br/>
	        我们的网站旨通过持续的宣传和推广，让大家了解到流浪猫的生存状况和现实难处。</p>
	    </div>
	  </div>
	</div>
	<div class="maomao">
		<p>
			<h2 id="h2">保护流浪猫的重要性</h2>
			流浪猫是城市中的一种野生动物，它们往往在没有人照顾的情况下生活，面对着很多的危险，例如饥饿、疾病和人类的暴力。虽然野生动物园或者动物保护机构通常会提供对流浪猫的庇护，但是这些机构资源往往有限，难以覆盖所有的需要帮助的流浪猫。
			<br/>首先，这些动物是我们城市的一部分。与我们所生活的城市环境一样，它们在维持生态平衡方面发挥着重要的作用。流浪猫还可以控制老鼠等害虫的数量，防止它们对城市造成危害。流浪猫是一个完整的生态系统中的一部分，我们需要为它们提供保护。
			<br/>其次，保护流浪猫也是一种对动物的敬重表现。流浪猫并不是无价的生命，它们跟我们人类一样有着自己的价值和尊严。我们应该更加关注它们的生存环境，并确保它们的权益得到应有的保护。
			那么，我们如何才能保护这些无助的动物呢？<br/>
			1.我们可以通过帮助或投资流浪动物庇护中心，为公益事业出一份力量。我们可以通过捐款、做志愿者或者提供其他资源帮助它们度过困难时期，同时也帮助了需要它们照顾的流浪猫。
			<br/>2.我们可以通过社交媒体，例如Facebook、Twitter、微博等，向很多群众宣传流浪猫保护的知识。
			<br/>3.我们自己也可以为流浪猫贡献一份力量。我们可以把饲养宠物时的剩余食物留给宠物猫。
		</p>
	
	
	</div>
	</div>
</body>