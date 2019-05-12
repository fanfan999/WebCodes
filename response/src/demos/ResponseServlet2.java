package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseServlet2", urlPatterns = "/responseServlet2")
public class ResponseServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了ResponseServlet2的dopost()方法");
        System.out.println("即将重定向到ResponseServlet3的dopost()方法");
        response.sendRedirect("/response/responseServlet3");
        //System.out.println("即将重定向到servletcodes模块下的requestDemo6中去");
        //response.sendRedirect("https://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
