package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JdbcUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取,只需要值读取一次: 使用静态代码块
     */
    static {
        //读取配置文件,获取值
        try {
            //1.方式1,Properties集合类
            Properties prop = new Properties();

            //我们运行发现,用相对路径src\\jdbc.properties会报错找不到路径,
            //必须写成这样JDBC\src\jdbc.properties或者使用绝对路径
            //为了方便,我们这里需要用到一个类,获取src路径下文件--> ClassLoader(类加载器)
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();//动态获取配置文件的绝对路径
            System.out.println(path);

            //2.加载文件
            prop.load(new FileReader(path));

            //3.获取数据,赋值
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接的工具方法
     *
     * @return 返回连接对象
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 释放资源,没有用到结果集时
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {

        //这里stmt和conn的关闭不能放在同一个try块中,
        // 防止其中一个异常而导致另一个没有关闭,造成资源浪费
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 释放资源,用到结果集时
     *
     * @param stmt
     * @param conn
     * @param rs
     */
    public static void close(Statement stmt, Connection conn, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
