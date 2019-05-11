package test;

import dao.UserDao;
import domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * for test
 */
public class UserDaoTest {

    @Test
    public void testLogin() throws SQLException {
        //封装一个测试对象user
        User testUser = new User();
        testUser.setName("fan");
        testUser.setPassword("123456");

        UserDao user = new UserDao();
        User result = user.login(testUser);
        System.out.println(result);
    }
}
