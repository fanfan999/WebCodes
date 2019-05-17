package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置request编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        //获取图片中生成的验证码
        HttpSession session = request.getSession();
        String checkCode_true = (String)session.getAttribute("checkCode_session");
        //获取完立即删除验证码,实现验证码只能用一次,防止后退之后验证码不变,可以使用多次
        //这样以后,你登录之后,回退验证码就已经失效了,再次输入原来的验证码会报错
        session.removeAttribute("checkCode_session");
        //判断验证码是否有效
        if ((checkcode == null) || (username == null) || (password == null)) {
            response.getWriter().write("<h1>表格输入无效</h1>");
            return;
        }else if ((checkcode.length() == 0) || (username.length() == 0) || (password.length() == 0)) {
            response.getWriter().write("<h1>表格不能为空,3秒后跳转到登陆界面</h1>");
            //然后重定向回登录界面
            response.setHeader("refresh","3;/logindemo/login.jsp");
        }else {
            //判断验证码是否正确,不区分大小写
            if (checkcode.equalsIgnoreCase(checkCode_true)) {
                //正确就继续比较账号和姓名
                if (username.equalsIgnoreCase("fan") && password.equalsIgnoreCase("123")) {
                    //账号密码正确就跳转到success.jsp同时将名字也传过去
                    HttpSession success_session = request.getSession();
                    success_session.setAttribute("success_username", username);
                    response.sendRedirect("/logindemo/success.jsp");
                }else {
                    //当用户名或者账号不正确时,就跳转回登录界面
                    response.getWriter().write("<h1>用户名或密码错误,3秒后跳转到登陆界面</h1>");
                    //然后重定向回登录界面
                    response.setHeader("refresh","3;/logindemo/login.jsp");
                }
            } else {
                //验证码不一致,就跳转回登录页面.
                response.getWriter().write("<h1>验证码错误,3秒后跳转到登陆界面</h1>");
                //然后重定向回登录界面
                response.setHeader("refresh","3;/logindemo/login.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
