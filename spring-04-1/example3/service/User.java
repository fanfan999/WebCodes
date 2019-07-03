package example3.service;

import org.springframework.stereotype.Service;

/**
 * 因为这里是service层,有专门的service注解
 */
@Service("user")
public class User {
    public int addUser() {

        System.out.println("没有参数添加用户!");

        return 1;
    }

    public int addUser(int i) {

        System.out.println("一个参数添加用户!");

        return 2;
    }

    public int addUser(int i, int j) {

        System.out.println("两个参数添加用户!");

        return 3;
    }
}
