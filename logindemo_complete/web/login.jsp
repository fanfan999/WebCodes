<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/16
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/logindemo/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>
</head>
<body>
<form action="/logindemo/loginServlet" method="post" >
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密  码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkcode" placeholder="请输入验证码"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/logindemo/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
