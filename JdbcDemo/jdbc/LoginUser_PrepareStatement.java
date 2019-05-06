package fan;

import util.JdbcUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用PrepareStatement改造登录案例
 */
public class LoginUser_PrepareStatement {
    public static void main(String[] args) {
        //键盘录入
        String username = null;
        String password = null;
        boolean flag = false;

        //这里使用try-with-resources方式声明流,系统会自动关闭流,这是JDK7新特性
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("请输入用户名:");
            username = br.readLine();
            System.out.println("请输入密码:");
            password = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //对象不能为空
        if (username != null && password != null){
        //调用方法,并接收返回值
        flag = isLogin(username, password);
        }

        //判断是否存在
        if (flag) {
            System.out.println(username + "---" + password + "登录成功!");
        }else {
            System.out.println(username + "---" + password + "登录失败!");
        }

    }
    
    public static boolean isLogin(String username, String password) {
        //定义布尔变量
        boolean flag = false;
        //创建数据库连接对象
        Connection conn = null;
        //定义sql语句
        String sql = "select * from usertable where username = ? and password = ?";
        //创建执行sql语句对象
        PreparedStatement ps = null;
        //定义结果集对象
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();

            ps = conn.prepareStatement(sql);

            //给参数设置值
            ps.setString(1, username);
            ps.setString(2, password);

            //执行sql语句
            rs = ps.executeQuery();

            //rs.next()本身返回的就是布尔值,true表示存在,fanlse表示不存在
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JdbcUtils.close(ps, conn,rs);
        }

        return flag;
    }
}
