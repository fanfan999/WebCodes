<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/19
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstlDemo1_if标签</title>
</head>
<body>
<%--
c:if标签
    1.属性
        test, 必须属性,接收boolean表达式,
            如果表达式为true,则显示if标签体内容
            如果表达式为false,则不显示if标签体内容
            如果表达式什么都不是也不会显示if标签体内容
            一般情况下,test属性值会结合el表达式的empty运算符,比较运算符,逻辑运算符等一起使用.
        注意: c:if标签没有else情况,想要else情况,就要重写一遍c:if标签
--%>
<c:if test="true">
    <h1>这是if标签为true的演示结果</h1>
</c:if>
<c:if test="false">
    <h1>这是if标签为false的演示结果</h1>
</c:if>

<%--判断resuest域中的一个list集合是否为空,不为空则显示遍历集合--%>
<%
    List list = new ArrayList();
    list.add("fanfan");
    request.setAttribute("listEl",list);
%>
<c:if test="${not empty listEl}">
    <h1>遍历集合</h1>
</c:if>


<%--
choose标签写一个星期几小案例
    1. 在域中存储一个数字.
    2. 使用choose标签取出数字 相当于switch的声明.
    3. 使用when标签做数字的判断,相当于case.
    4. otherwise标签做其它情况的声明,相当于default.
--%>
<%
    request.setAttribute("number", 3);
%>

<c:choose>
    <c:when test="${number == 1}">
        星期一
    </c:when>
    <c:when test="${number == 2}">
        星期二
    </c:when>
    <c:when test="${number == 3}">
        星期三
    </c:when>
    <c:when test="${number == 4}">
        星期四
    </c:when>
    <c:when test="${number == 5}">
        星期五
    </c:when>
    <c:when test="${number == 6}">
        星期六
    </c:when>
    <c:when test="${number == 7}">
        星期日
    </c:when>
    <c:otherwise>
        你输入的数字有误,应为1-7.
    </c:otherwise>
</c:choose>
<br>

<%--
foreach标签,相当于for循环
    完成重复的操作.
        for(int i = 0; i < 10; i++) {
        }

        在jstl中
        属性:
            begin: 开始值,包含
            end: 结束值,包含
            var: 临时变量
            step: 步长,即临时变量每次增长几
            varStatus: 循环状态对象(在重复操作中不怎么用在遍历容器使用)
                index: 容器中元素的索引,从0开始,在for循环完成重复性操作时和i一致.
                count: 循环次数,从1开始
    遍历容器.
        List<User> list
        for(User u : list){
        }

        在jstl中
        属性:
            items: 容器对象 相当于上面的list
            var: 容器中的临时变量 相当于上面的u
            varStatus: 循环状态对象
                index: 容器中元素的索引,从0开始
                count: 循环次数,从1开始
--%>
<br>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    ${i} <h3>${s.index}</h3> <h4>${s.count}</h4><br>
</c:forEach>

<%
    List list1 = new ArrayList();
    list1.add("list1");
    list1.add("list2");
    list1.add("list3");
    list1.add("list4");

    request.setAttribute("listEl1", list1);
%>
<c:forEach items="${listEl1}" var="str" varStatus="s">
    ${str} ${s.index} ${s.count}
</c:forEach>

</body>
</html>
