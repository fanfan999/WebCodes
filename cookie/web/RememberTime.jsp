<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>改造记住上次访问时间</title>
</head>
<body>
<%!
    public String getTime() throws UnsupportedEncodingException {
        //获取时间并且对其进行格式化
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println("当前时间 : " + time);
        //由于cookie不支持空格这些特殊符号,所以需要将其转换为url编码
        time = URLEncoder.encode(time, "Unicode");

        return time;
    }
%>

<%
    //设置编码
    //response.setContentType("text/html;charset=Unicode");

    //该布尔变量用于判断是否已经有指定键值对的cookie对象
    boolean flag = false;

    //获取cookie数组
    Cookie[] cookies = request.getCookies();
    //判断cookie是否有效
    if (cookies == null) {
        return;
    }
    //遍历数组判断cookie是否包含指定的键值对
    for (Cookie c : cookies) {
        String name = c.getName();
        if (name.equals("curTime")){
            //存在指定键
            flag = true;
            //获取cookie中携带的时间
            String value = c.getValue();
            //对value进行解码
            value = URLDecoder.decode(value, "Unicode");
%>

            <h1>欢迎回来,您上次访问时间为 : <%=value%></h1>
<%
            //更新时间
            String time = getTime();
            c.setValue(time);
            response.addCookie(c);
            break;
        }
    }

    if (flag == false) {
        //走到这里,就说明原来的cookie中没有指定的键值对,响应cookie
%>
        <h1>欢迎您首次访问!</h1>
<%
        //获取时间
        String time = getTime();
        Cookie cookie = new Cookie("curTime", time);
        //设置时间持久化存储
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }
%>
</body>
</html>
