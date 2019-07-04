package example4.dao;

import example4.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 对数据库 的User表进行操作
 * jdbctemplate用来操作数据库,是作用在dao层的
 */
public class UserDao {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void addUser(User user) {
        String sql = "insert into user(username, password) values(?,?)";
        int i = template.update(sql, user.getUsername(), user.getPassword());
        System.out.println("成功添加" + i + "条用户记录");
    }
}
