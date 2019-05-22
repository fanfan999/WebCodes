package web.servlet;

import com.sun.org.apache.regexp.internal.REUtil;
import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 分页查询
 */
@WebServlet(name = "FindUserByPageServlet", urlPatterns = "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //获取请求参数,当前页码和每页显示的条数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //获取条件查询时的请求参数姓名籍贯邮箱封装为map集合{u1=user{name="fan", age=11}}
        //获取不到值就两种情况,一种是form表单中没有action属性,另一种是input输入框没有name属性
        Map<String, String[]> parameterMap = request.getParameterMap();
        //判断currentPage和rows是否有效,都为空我们手动赋值为1和5
        if (currentPage == null || "".equalsIgnoreCase(currentPage) || 0 >= Integer.parseInt(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equalsIgnoreCase(rows)) {
            rows = "5";
        }
        //System.out.println("---" + currentPage);
        //调用service查询
        UserService userService = new UserServiceImpl();
        PageBean<User> userByPage = userService.findUserByPage(currentPage, rows, parameterMap);
        //将pageBean存入request
        request.setAttribute("pageBean", userByPage);
        //将查询条件存入request
        request.setAttribute("parameterMap", parameterMap);
        //转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
