package examples.service;

import examples.dao.UserDao;
import examples.domain.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
        System.out.println("实例化UserService类的对象");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        System.out.println("service层 调用add()方法,即将传送给dao层调用");
        userDao.add(user);
    }
}
