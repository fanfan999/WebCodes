package example6.dao;

import example6.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 对数据库 的User表进行操作
 * jdbctemplate用来操作数据库,是作用在dao层的
 */
public class UserDao extends JdbcDaoSupport {


    public void addUser(User user) {
        String sql = "insert into user(username, password) values(?,?)";

        //获取父类的jdbctemplate属性,这里的super也可以换成this(省略也可以,省略默认就会有this),因为自己没有它会默认去找父类的.
        JdbcTemplate template = super.getJdbcTemplate();

        int i = template.update(sql, user.getUsername(), user.getPassword());
        System.out.println("成功添加" + i + "条用户记录");
    }

}
