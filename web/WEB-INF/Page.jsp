<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <title>分页</title>
    <style type="text/css">
        a{
            font-size:14px;
            text-decoration:none;
        }
        td{
            text-align:center;
        }
        #prevPage{
            padding:6px;
            color:blue;
            width:24px;
            height:24px;
            border:1px solid #ccc;
        }
        #pageNum{
            padding-top:6px;
            padding-left:12px;
            color:blue;
            border:1px solid #ccc;
            padding-right:12px;
            padding-bottom:6px;
        }
        #nextPage{
            padding:6px;
            color:blue;
            width:24px;
            height:24px;
            border:1px solid #ccc;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
</head>
<body>
<div class="container" id="pagenation" align="center">
    <table border="1" width="80%" cellpadding="5" cellspacing="0">
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>性别</th>
        </tr>
        <c:forEach items="${page.showUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.gender}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <c:when test="${page.currentPage==1}">
        <上一页
    </c:when>
    <c:otherwise>
        <a href="http://localhost:8080/paging/user.htm?currentPage=${page.prevPage}" id="prevPage"><上一页</a>
    </c:otherwise>
    <c:forEach items="${page.showPageNums}" var="pageNum">
        <a href="http://localhost:8080/paging/user.htm?currentPage=${pageNum}" id="pageNum">${pageNum}</a>
    </c:forEach>
    <a href="http://localhost:8080/paging/user.htm?currentPage=${page.nextPage}" id="nextPage">下一页></a>
</div>
</body>
<script type="text/javascript">
    $(function(){
        $("#prevPage").mousemove(function(){
            $("#prevPage").css("border-color","#4a86e8");
            $("#prevPage").css("background","#d5dce8");
        });
        $("#prevPage").mouseout(function(){
            $("#prevPage").css("border-color","#ccc");
            $("#prevPage").css("background","white");
        });
        $("#nextPage").mousemove(function(){
            $("#nextPage").css("border-color","#4a86e8");
            $("#nextPage").css("background","#d5dce8");
        });
        $("#nextPage").mouseout(function(){
            $("#nextPage").css("border-color","#ccc");
            $("#nextPage").css("background","white");
        });

    });
</script>
</html>