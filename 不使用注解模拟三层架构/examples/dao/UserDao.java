package examples.dao;

import examples.domain.User;

public class UserDao {

    public UserDao() {
        System.out.println("实例化UserDao类的对象");
    }

    public void add(User user){
        System.out.println("dao层 调用add()方法添加对象:" + user);
    }
}
