<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流浪猫信息</title>
</head>
<script src="https://cdn.lordicon.com/ritcuqlt.js"></script>  
<link rel="stylesheet" href="css/CatDisplay.css">
			
<body>
<div class="container">  
        <div id="slide">  
        <c:forEach var="cat" items="${catList}" varStatus="loop">
            <div class="item" style="background-image: url(img/${cat.catnum}.jpg);">  
                <div class="content">  
                    <div class="name">${cat.name}</div>  
                    <div class="des">
                    品种：${cat.breed}</br>
                    年龄：${cat.age}岁</br>
                    性别：${cat.sex}</br>
                    出没地点：${cat.address}</br>
                    性格：${cat.character}</br>
                    </div>  
                      
                </div>  
            </div>  
            </c:forEach>
        </div> 
         
        <div class="buttons">  
            <div class="s_button"><</div>  
            <div class="s_button">></div>  
        </div>  
    </div>  
    <script>  
        let _direction = true;  
        let _move = () => {  
            let lists = document.querySelectorAll(".item")  
            if (_direction) {  
                document.querySelector("#slide").appendChild(lists[0]);  
            } else {  
                document.querySelector("#slide").prepend(lists[lists.length - 1]);  
            }  
        }  
        let timer = setInterval(_move, 4000);  
        document.querySelector(".container").addEventListener("mouseover", () => {  
            clearInterval(timer);  
        });  
        document.querySelector(".container").addEventListener("mouseout", () => {  
            timer = setInterval(_move, 4000)  
        });  
        document.querySelectorAll(".s_button")[1].onclick = () => {  
            _direction = true;  
            _move();  
        }  
        document.querySelectorAll(".s_button")[0].onclick = () => {  
            _direction = false;  
            _move();  
        }  
    </script>  
    
</body>
</html>