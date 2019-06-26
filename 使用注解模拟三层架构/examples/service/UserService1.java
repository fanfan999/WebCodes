package examples.service;

import examples.dao.UserDao;
import examples.dao.UserDao1;
import examples.domain.User;
import examples.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //代表这就是一个service层了,而且配置了一个bean,也就是一个UserService1对象
public class UserService1 {

    @Autowired //spring会往userDao赋值,把容器中的UserDao1对象赋值过来
    private UserDao1 userDao1;

    public UserService1() {
        System.out.println("实例化UserService类的对象");
    }

    public void add(User1 user) {
        System.out.println("service层 调用add()方法,即将传送给dao层调用");
        userDao1.add(user);
    }
}
