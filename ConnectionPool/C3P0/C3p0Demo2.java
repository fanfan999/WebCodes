package ConnectionPool.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0连接池参数配置演示
 */
public class C3p0Demo2 {
    public static void main(String[] args) {
        //一般使用默认的就可以了
        testDefaultConfig();
        testNamedConfig();
        /*//创建数据库连接池对象,无参则使用默认配置,传参则使用指定名称的配置
        //DataSource ds = new ComboPooledDataSource();
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //获取连接对象
        Connection conn = null;

        try {
            //测试最大连接数量是否为10个
            //当我们的连接<=10时,正常运行,当>10的时候,过3秒就会报错
            for (int i = 1; i <= 11; i++) {
                conn = ds.getConnection();
                //输出连接对象
                System.out.println(i + "--" + conn);

                //如果我们非要获取第11个咋整,
                //在这里我们假设第5个线程运行比较快,很快就归还了,
                //也可以在finally中写一个语句conn.close,表示第一个连接对象在使用结束后就归还了,再执行下一次循环
                //所以后面不管循环多少次,都不会报错,而且使用的都是同一个连接对象.
                if (i == 5) {
                    //归还连接对象到连接池,此时11就可以访问了
                    //此时运行发现,5和6使用的对象是同一个,也验证了该对象是归还到了连接池中
                    conn.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    //测试自定义配置,最大连接数为12
    private static void testNamedConfig() {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //获取连接
        Connection conn = null;
        try {
            conn = ds.getConnection();

            //测试最大连接数
            for(int i = 1; i <= 12; i++) {
                System.out.println(i + "---" + conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试自定义配置,最大连接数为10
    private static void testDefaultConfig() {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接
        Connection conn = null;
        try {
            conn = ds.getConnection();

            //测试最大连接数
            for(int i = 1; i <= 10; i++) {
                System.out.println(i + "---" + conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
