<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.user.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/19
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl小练习</title>
</head>
<body>
<%--准备user对象的list集合--%>
<%
    User user1 = new User("user1", 1, new Date());
    User user2 = new User("user2", 2, new Date());
    User user3 = new User("user3", 3, new Date());
    User user4 = new User("user4", 4, new Date());
    User user5 = new User("user5", 5, new Date());

    List<User> list = new ArrayList<>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    list.add(user4);
    list.add(user5);

    request.setAttribute("listPrac", list);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <c:forEach items="${listPrac}" var="user" varStatus="s">

        <%--给奇数行和偶数行换颜色--%>
        <c:if test="${s.count % 2 == 0}">
            <tr style="text-align: center" bgcolor="aqua">
                <td>
                        ${s.count}
                </td>
                    <%--这里直接用属性和用方法都是可以的--%>
                <td>${user.name}</td>
                <td>${user.getAge()}</td>
                    <%--注意这里的生日不能用西方的日期,会报错,因为在user没有getBirthday方法,只有getBirStr()--%>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
        <%--奇数行--%>
        <c:if test="${s.count % 2 != 0}">
            <tr style="text-align: center" bgcolor="#ffebcd">
                <td>
                        ${s.count}
                </td>
                    <%--这里直接用属性和用方法都是可以的--%>
                <td>${user.name}</td>
                <td>${user.getAge()}</td>
                    <%--注意这里的生日不能用西方的日期,会报错,因为在user没有getBirthday方法,只有getBirStr()--%>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
