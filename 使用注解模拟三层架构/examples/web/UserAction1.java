package examples.web;

import examples.domain.User;
import examples.domain.User1;
import examples.service.UserService;
import examples.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //也就相当于创建了一个bean,也就是一个UserAction1对象
public class UserAction1 {

    @Autowired //spring会自动为userService赋值,把容器中的UserService1对象赋值过来
    private UserService1 userService1;

    public UserAction1() {
        System.out.println("实例化UserAction的对象");
    }

    public void add(User1 user) {
        System.out.println("web层 调用add()方法,即将传送给service层调用");
        userService1.add(user);
    }
}
