package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当浏览器传来的请求消息ResponseServlet1搞不定的时候,它就会响应说我干不了,ResponseServlet2可以干
 * 在响应消息中应该有这么两条内容
 * 1. 告诉浏览器要重定向,通过setStatus()设置状态码302实现
 * 2. 告诉浏览器ResponseServlet2的路径,通过响应头location:告诉浏览器ResponseServlet2资源路径实现
 */
@WebServlet(name = "ResponseServlet1", urlPatterns = "/responseServlet1")
public class ResponseServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了ResponseServlet1的dopost()方法");

        System.out.println("即将重定向到ResponseServlet2的dopost()方法");

        //访问/responseServlet1,会自动跳转到/responseServlet2

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseServlet2");
        //这行代码重定向和下面的重定向效果一样
        //response.sendRedirect("/response/responseServlet2");

        /*//告诉浏览器要重定向
        response.setStatus(302);
        //设置响应头,设置告诉浏览器重定向的位置
        response.setHeader("location", "/responseServlet2");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
