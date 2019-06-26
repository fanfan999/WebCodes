package examples;

import examples.domain.User;
import examples.domain.User1;
import examples.web.UserAction1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解模拟三层架构
 */
public class Test1 {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans12.xml");

        //获取user对象并赋值
        User1 user1 = (User1) context.getBean("user1");
        user1.setName("樊磊");
        user1.setAge(18);
        //获取web层对象
        UserAction1 userAction1 = context.getBean(UserAction1.class);
        userAction1.add(user1);

    }
}
