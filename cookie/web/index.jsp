<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp脚本测试</title>
  </head>
  <body>
  <%
    System.out.println("hello, jsp");
    int i = 9;
  %>

  <%!
    int i = 6;
  %>

  <%=
    i
  %>
  </body>
</html>
