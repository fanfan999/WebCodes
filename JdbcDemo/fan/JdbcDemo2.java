package fan;

import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 * jdbc快速入门
 */
public class JdbcDemo2 {
    public static void main(String[] args) {

        ArrayList<StudentInfo> lists = new ArrayList<>();
        findAll(lists);
        System.out.println(lists);
    }

    private static void findAll(ArrayList<StudentInfo> lists) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StudentInfo stu = null;
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();

            //查询
            String sql = "select * from studentinfo";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String nickName = rs.getString("nickname");
                String realName = rs.getString("realname");

                stu = new StudentInfo(id, nickName, realName);
                lists.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(stmt, conn, rs);
            /*//释放资源的时候,后面使用的资源先释放,对象操作都要判断是否为空再进行操作
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //因为资源一定要关闭不管是否发生错误,所以要放在finally中
            try {
                //最好是把stmt.close写在前面,因为stmt是conn调方法产生的
                //考虑到conn,stmt当账号或者密码等出错以后可能出项空指针异常,
                // 所以这里需要判断不为空以后再关闭.
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
}
