package ConnectionPool.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * druid演示代码
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        //生成数据库连接对象
        Connection conn = null;
        //生成数据库语句操作对象
        PreparedStatement pstmt = null;
        try {
            //获取连接对象
            conn = DruidUtils.getConn();
            //定义sql语句
            String sql= "insert into product values(null, ?, ?)";
            //获取sql执行对象
            pstmt = conn.prepareStatement(sql);
            //给sql中变量赋值
            pstmt.setString(1, "鼠标");
            pstmt.setDouble(2, 100);
            //执行sql
            int count = pstmt.executeUpdate();
            //输出对象地址和count
            System.out.println(count + "---" + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            DruidUtils.close(pstmt, conn);
        }

    }
}
