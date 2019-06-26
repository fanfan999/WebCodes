package examples;

import examples.dao.UserDao;
import examples.domain.User;
import examples.service.UserService;
import examples.web.UserAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 不带注解三层架构的测试类
 */
public class Test {

    @org.junit.Test
    public void test() {
        //获取容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans12_1.xml");

        //获取容器中的bean对象
        User user = (User) context.getBean("user");
        UserDao userDao = (UserDao) context.getBean("userDao");
        UserService userService = (UserService) context.getBean("userService");
        UserAction userAction = (UserAction) context.getBean("userAction");

        //调用方法
        userAction.add(user);
    }
}
