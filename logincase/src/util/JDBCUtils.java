package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类, 使用durid连接池
 */
public class JDBCUtils {

    private static DataSource dataSource = null;

    //根据配置文件创建给连接池初始化,让其不为null
    static {
        try {
            //加载配置文件
            Properties prop= new Properties();
            //使用classloader来加载配置文件,获取字节输入流
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //读取配置文件,此时prop里面都是键值对了.
            prop.load(inputStream);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(prop);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取连接Connection对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
