package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登录功能
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //当直接输入网址时,会报空指针异常
        if (request == null) {
            //空指针就直接跳转到登陆界面
            response.sendRedirect("/login.jsp");
        }
        //获取数据(用户填写的验证码,姓名,密码)
        String verifycode = request.getParameter("verifycode");

        //对验证码进行校验
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //让验证码立即失效
        request.removeAttribute("CHECKCODE_SERVER");
        User user = new User();
        //验证码正确就继续判断其它内容
        if (verifycode.equalsIgnoreCase(checkcode_server)) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            //封装对象
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            //验证码不正确
            //测试
            System.out.println("wrong!");
            //给出提示信息
            request.setAttribute("login_msg", "验证码错误!");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            //退出
            return;
        }
        //调用service查询
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        System.out.println(loginUser);
        //判断是否登录成功
        if (loginUser != null) {
            //登录成功
            // 将用户存入session
            HttpSession userSession = request.getSession();
            userSession.setAttribute("user", loginUser);
            // 就跳转到成功页面
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //测试
            System.out.println("failed!");
            //给出提示信息
            request.setAttribute("login_msg", "登录失败!用户名或密码错误");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
