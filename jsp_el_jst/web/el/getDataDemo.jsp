<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>从域中获取数据案例</title>
</head>
<body>
<%
    //通过request存储对象
    request.setAttribute("requestMsg","this is requestDemo");
%>
<%--通过requestScope获取值--%>
${requestScope.requestMsg}
<br>
<%
    //通过session存储对象
    session.setAttribute("sessionMsg","this is sessionDemo");
%>
<%--通过sessionScope获取值--%>
${sessionScope.sessionMsg}
<br>
<%--当不存在时,它会输出空字符串"",不会报错也不会输出null--%>
${sessionScope.sessionMsg1}
<br>

<%--使用第二种写法获取值--%>
${requestMsg}
<br>
${sessionMsg}
<br>
</body>
</html>
