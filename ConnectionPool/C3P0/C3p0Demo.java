package ConnectionPool.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0连接池案例,记得要导入驱动的jar包,因为说到底这还是针对数据库的操作
 */
public class C3p0Demo {
    public static void main(String[] args) {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = null;

        try {
            conn = ds.getConnection();

            //输出连接对象
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
