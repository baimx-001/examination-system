<%--
  Created by IntelliJ IDEA.
  User: BMX
  Date: 2020/1/20
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        background:url("/img/login-background.jpg") no-repeat center fixed;
    }
</style>
<body>
<center>
    <h1 style="color:red">在线考试系统</h1>
    <form id="indexform" name="indexForm" action="/checkLogin" method="post">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"><span>${message}</span>
                </td>
            </tr>

        </table>
        <br>
        <input type="submit" value="登录" style="color:#BC8F8F">
    </form>
    <%--<form action="zhuce.jsp">--%>
    <%--<input type="submit" value="注册" style="color:#BC8F8F">--%>
    <%--</form>--%>
</center>
</body>
</html>
