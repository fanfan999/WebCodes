package example3;

import example3.service.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解配置AOP
 */
public class UnitClass {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        User user = (User) context.getBean("user");

        user.addUser();
        System.out.println("--------");

        user.addUser(1);
        System.out.println("--------");

        user.addUser(1,2);
    }
}
