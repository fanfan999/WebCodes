<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El的隐式对象</title>
</head>
<body>
${pageContext.request}
<h4>在jsp页面动态获取虚拟目录,可以放在jsp中的form表单的action中</h4>
${pageContext.request.contextPath}
</body>
</html>
