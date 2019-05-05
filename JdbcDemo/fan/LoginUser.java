package fan;

import util.JdbcUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 根据键盘录入判断是否存在该用户
 */
public class LoginUser {
    public static void main(String[] args) {

        //键盘录入
        String user = null;
        String password = null;

        //这里使用try-with-resources方式声明流,系统会自动关闭流,这是JDK7新特性
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            user = br.readLine();
            password = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取数据库连接
        Connection conn = JdbcUtils.getConnection();
        //获取所有数据
        String sql = "select * from usertable";
        //获取执行数据库语句对象
        Statement stmt = null;
        //获取数据库数据结果集
        ResultSet rs = null;
        //定义一个布尔变量控制输出
        boolean flag = false;
        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            //循环获取所有数据与键盘录入比对
            while (!flag && rs.next()) {

                    String name = rs.getString("username");
                    String pw = rs.getString("password");

                    //存在就把flag置为true,同时退出循环
                    if (name.equals(user) && pw.equals(password)){
                        flag = true;
                        break;
                    }
            }

            //如果循环结束了还没有匹配到,就说明不存在
            if (flag != true) {
                System.out.println("登录失败");
            }else {
                System.out.println(user + "---" + password + "登录成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //关闭资源
        JdbcUtils.close(stmt, conn, rs);
    }
}
