package login.servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式,防止post方法乱码
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //封装user对象
        User user = new User(userName, password);
        //使用BeanUtils简化操作
        //获取所有请求参数,这个也是获取不到用户名,用户名永远为null,我的妈
        /*Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        //创建一个user对象
        User user = new User();
        try {
            //使用beanutils封装user
            //该方法一调用,map集合的数据就封装到user里面了
            BeanUtils.populate(user, parameterMap);
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        //通过userdao对象调用login方法
        UserDao userDao = new UserDao();
        try {
            //这里的resultUser就是我们真正获取到的user
            User resultUser = userDao.login(user);
            System.out.println(resultUser);
            //不为空则表示登录成功
            if (resultUser != null) {
                //存储数据,"msg"表示键为msg,另一个参数表示值为user对象
                request.setAttribute("msg", resultUser);
                //装发
                request.getRequestDispatcher("/successServlet").forward(request, response);
            }else {
                //跳转
                request.getRequestDispatcher("/failServlet").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
