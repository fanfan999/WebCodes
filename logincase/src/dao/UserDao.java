package dao;

import domain.User;
import org.springframework.jdbc.core.*;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 操作数据库中user表的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法,接收用户从页面上传来的user对象,然后判断数据库中是否存在
     * 存在就返回user的所有信息
     * @param loginUser 这就是用户在页面上输入的信息封装成的user对象
     * @return 返回数据库中该user的所有信息,不存在就返回null
     */
    public User login(User loginUser) throws SQLException {
        //定义一个准备返回的user空对象
        User user = null;
        //编写sql
        String sql = "select * from user where username = ? and password = ?";
        //String sqls = "select * from user where username = ? and password = ?";
        //String sqls = "select * from user where id = ?";
        //从页面传过来的数据
        String loginName = loginUser.getName();
        String loginPassword = loginUser.getPassword();
        //System.out.println(loginName+loginPassword);
        //执行sql,该方法会返回一个user对象,这个查询出来姓名总是为null,不知道为啥
        /*User user1 = template.queryForObject(sqls,
                new BeanPropertyRowMapper<User>(User.class),loginName, loginPassword);
        System.out.println(user1);*/
        //使用query方法
        /*template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, loginName);
                ps.setString(2, loginPassword);
            }
        }, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                String name = rs.getString("username");
                String password = rs.getString("password");
                user = new User(name, password);
                //System.out.println(user);
                return user;
            }
        });*/

        //获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //赋值
        ps.setString(1, loginName);
        ps.setString(2, loginPassword);

        //执行sql语句
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            user = new User(username, password);
        }

        return user;
    }

}
