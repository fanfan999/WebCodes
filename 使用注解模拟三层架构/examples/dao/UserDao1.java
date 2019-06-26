package examples.dao;

import examples.domain.User1;
import org.springframework.stereotype.Repository;

@Repository //就相当于在容器中配置了一个bean,也就是一个UserDao1对象
public class UserDao1 {

    public UserDao1() {
        System.out.println("实例化UserDao类的对象");
    }

    public void add(User1 user){
        System.out.println("dao层 调用add()方法添加对象:" + user);
    }
}
