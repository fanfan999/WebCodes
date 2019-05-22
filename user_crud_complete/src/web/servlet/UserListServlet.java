package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserListServlet", urlPatterns = "/userListServlet")
public class UserListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //1.调用UserService完成查询
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();

        //将list存入request域
        request.setAttribute("users", users);
        //转发到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
