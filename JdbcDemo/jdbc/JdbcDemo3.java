package jdbc;

import util.JdbcUtils;

import java.sql.*;

/**
 * 演示事务的操作
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        //方便释放资源
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        //定义sql语句
        //平板减50,华硕加50.
        String sql = "update product set price = price - ? where id = ?";
        String sql2 = "update product set price = price + ? where id = ?";

        try {
            //获取数据库连接
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //获取执行sql对象
            ps = conn.prepareStatement(sql);
            ps2 = conn.prepareStatement(sql2);
            ps.setDouble(1, 50.0);
            ps.setInt(2, 1);

            ps2.setDouble(1, 50.0);
            ps2.setInt(2, 3);

            //执行sql语句
            int count = ps.executeUpdate();
            //手动制造一点异常,以至于count2语句无法被执行
            //为了防止这种事情出现,我们可以通过事务来处理
            int i = 3/0;

            int count2 = ps2.executeUpdate();

            System.out.println("count: " + count + "count2: " + count2);
            //没有问题就提交事务
            conn.commit();
        } catch (Exception e) {
            //出异常就会到catch里面,在这里我们可以进行回滚,
            // 所以我们在上面不管出现什么异常都会回滚.让它回到事务开启之前的状态
            // 同时又因为这里会出现很多异常,我们需要
            // 把SQLException改为最大的Exception
            try {
                //如果数据库连接为null,就不用回滚了
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //释放资源
            JdbcUtils.close(ps,conn);
            JdbcUtils.close(ps2,null);
        }

    }
}
