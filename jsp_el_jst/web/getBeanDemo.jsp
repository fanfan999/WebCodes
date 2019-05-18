<%@ page import="domain.user.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/17
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>获取对象的值</title>
</head>
<body>
<%--创建user对象并赋值--%>
<%
    User user = new User("user", 22, new Date());
    request.setAttribute("bean", user);
%>

<%--通过el表达式获取对象值--%>
${requestScope.bean}
<br>

<%--通过对象的属性(get和set方法去掉get和set,剩下的部分首字母小写,例如getName()的属性为name,一般和成员变量是相同的)来获取--%>
<%--这个bean.name实质上是bean对象调用getName方法,没有getName方法会报错--%>
${requestScope.bean.name}
<br>
${requestScope.bean.age}
<br>
<%--由于没有getBirthday方法,所以这句会报错--%>
<%--${requestScope.bean.birthday}--%>
<br>

<%--通过自定义方法getBirStr()的属性birStr获取格式化日期--%>
${requestScope.bean.birStr}
<br>


<%--创建集合并添加值--%>
<%
    List list = new ArrayList();

    list.add("abc");
    list.add("阿百川");

    request.setAttribute("listEL", list);
%>

<%--获取值--%>
${requestScope.listEL[0]}
<br>
<%--下标越界就显示空字符串,不会报错--%>
${requestScope.listEL[5]}
<br>
<%--不给索引就是获取全部值--%>
${requestScope.listEL}
<br>


<%--Map对象获取值--%>
<%
    Map map = new HashMap();
    map.put("fan1","aaa");
    map.put("fan2","bbb");

    request.setAttribute("mapEl", map);
%>
<%--获取值--%>
${requestScope.mapEl.fan1}
<br>
${requestScope.mapEl["fan2"]}
<br>
${requestScope.mapEl.fan3}
<br>
${requestScope.mapEl}
<br>



</body>
</html>
