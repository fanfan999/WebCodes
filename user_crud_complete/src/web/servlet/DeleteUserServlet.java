package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除联系人
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = "/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id,由于默认是get请求,编码是没有问题的所以不用手动设置编码
        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl();
        userService.deleteUserById(id);
        //跳转回展示所有信息页面
        response.sendRedirect(request.getContextPath()+ "/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
