package example4.Unit;

import example4.dao.UserDao;
import example4.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jdbcTemplate的使用
 */
public class UnitJdbcTemplate {

    @Test
    public void test() {
        //获取容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        //获取dao层的对象
        UserDao userDao = (UserDao) context.getBean("userDao");

        //添加用户
        User user = new User("fanlei", "111");

        //调用方法
        userDao.addUser(user);
    }
}
