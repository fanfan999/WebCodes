package examples.web;

import examples.domain.User;
import examples.service.UserService;

public class UserAction {

    private UserService userService;

    public UserAction() {
        System.out.println("实例化UserAction的对象");
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add(User user) {
        System.out.println("web层 调用add()方法,即将传送给service层调用");
        userService.add(user);
    }
}
