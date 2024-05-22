<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改猫咪</title>
<link rel="stylesheet" href="css/addcat.css">
</head>
<body>
<main class="table">
        <section class="header">
            <h1>校园小猫们</h1>
            <div class="input-group">
                <input type="search" placeholder="Search Data...">
                <img src="img/search.png">
            </div>
        </section>
        <section class="shell">
            <table>
                <thead>
                    <tr>
                        <th> 编号😹 </th>
                        <th> 姓名😾</th>
                        <th> 性别🙀</th>
                        <th>品种😺</th>
                        <th> 出没点😼</th>
                        <th> 性格😻</th>
                         <th> </th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="cat" items="${catList}" varStatus="loop">
    <tr>
        <td>${cat.catnum}</td>
        <td><img src="img/${cat.catnum}.jpg">${cat.name}</td>
        <td>${cat.sex}</td>
        <td>${cat.breed}</td>
        <td>${cat.address}</td>
        <td>${cat.character}</td>
        <td><button id="button_${cat.catnum}" class="button" onclick="deleteCat('${cat.catnum}')">删除</button></td>
    </tr>
</c:forEach>
                               
                </tbody>
            </table>
        </section>
    </main>
    
     <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
    function deleteCat(catnum) {
    	  if (confirm("确定删除该猫咪吗？")) {
    	    window.location = 'http://localhost:8080/cat-1/deleteCatServlet?catnum=' + catnum;
    	  }
    	}
    </script>
</body>
</html>