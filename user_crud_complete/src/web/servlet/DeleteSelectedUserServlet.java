package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteSelectedUserServlet", urlPatterns = "/deleteSelectedUserServlet")
public class DeleteSelectedUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id数组
        String[] checkboxIds = request.getParameterValues("checkboxId");
        //调用userservice删除指定id
        UserService userService = new UserServiceImpl();

        userService.deleteSelectedUsers(checkboxIds);
        //跳转回显示所有信息servlet列表界面
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
