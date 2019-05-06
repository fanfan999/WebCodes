package ConnectionPool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * druid演示代码
 */
public class DruidDemo {
    public static void main(String[] args) {
        //加载配置文件
        Properties prop = new Properties();
        //生成properties文件的流对象,在这里为了方便将文件放到了src文件夹中
        InputStream input = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        //生成数据库连接对象
        Connection conn = null;
        try {
            //加载到配置文件到prop中
            prop.load(input);
            //获取数据库连接池对象
            DataSource dataPool = DruidDataSourceFactory.createDataSource(prop);
            //获取连接对象
            conn = dataPool.getConnection();
            //输出对象地址
            System.out.println(conn);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
