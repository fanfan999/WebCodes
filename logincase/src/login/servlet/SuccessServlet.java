package login.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuccessServlet", urlPatterns = "/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置页面编码
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getAttribute("msg");
        System.out.println(user);
        // 给页面写一句话
        response.getWriter().write("登录成功, "+ user.getName() + ", 欢迎您!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
