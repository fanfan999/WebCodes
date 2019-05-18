<%@ page import="domain.user.User" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page isErrorPage="true" %>
<%@page isELIgnored="true" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/loginServlet">

  </form>
  <h1>服务器还在忙,等一哈哈......</h1>

  <%
    request.setAttribute("msg", "hello");
  %>

  <%= request.getAttribute("msg")%>

  \${3 > 4}
  </body>
</html>
