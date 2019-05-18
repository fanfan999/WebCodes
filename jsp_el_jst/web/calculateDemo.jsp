<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符示例</title>
</head>
<body>
<h1>
    算术运算符
</h1>
<%--加法--%>
${3 + 4}<br>
<%--除法--%>
${6 / 2}<br>
${6 div 2}<br>
<%--取模--%>
${6 % 12}<br>
${6 mod 12}<br>
<%--比较运算符--%>
${6 == 12}<br>
<%--逻辑运算符--%>
${6 >= 12 && 1 < 2}<br>
${6 >= 12 and 1 < 2}<br>
<%--空运算符--%>
<%
    String str1 = "abc";
    request.setAttribute("str1El", str1);
    String str2 = "";
    request.setAttribute("str2El", str2);
    String str3 = null;
    request.setAttribute("str3El", str3);
%>
<%--不为空则为false--%>
${empty str1El}
<br>
<%--用not使得不为空且长度>0则为true--%>
${not empty str1El}
<br>
<%--为空或者null返回true--%>
${empty str2El}
<br>
${empty str3El}
</body>
</html>
