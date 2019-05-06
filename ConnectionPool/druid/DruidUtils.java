package ConnectionPool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid工具类
 */
public class DruidUtils {

    //创建连接池对象
    private static DataSource dataPool = null;
    //创建流对象
    private static InputStream input = null;
    private static Properties prop = null;

    //因为这个只需要初始化一次,
    // 所以通过静态代码块加载配置文件,初始化连接池对象
    static {
        prop = new Properties();
        //读取配置文件
        input = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(input);
            dataPool = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接的方法
    public static Connection getConn() {
        //获取数据库连接对象
        Connection conn = null;
        try {
            conn = dataPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    //获取数据库连接池的方法
    public static DataSource getDataSource() {
        return dataPool;
    }

    //释放资源
    public static void close(Statement stmt, Connection conn) {
        //不为空则归还到连接池中.
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
