<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功界面</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    String success_username = (String)session1.getAttribute("success_username");
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time = sdf.format(date);
%>
<h1>
    <%=success_username%>于<%=time%>登录成功!
</h1>

</body>
</html>
