package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public abstract List<User> findAll();

    /**
     * 判断用户是否存在并成功登录
     * @param user
     * @return
     */
    public abstract User login(User user);

    /**
     * 向数据库中添加对象
     * @param user
     */
    public abstract void addUser(User user);

    /**
     * 根据id删除对象
     * @param id
     */
    public abstract void deleteUserById(int id);

    /**
     * 通过id查询user对象信息
     * @param id
     */
    public abstract User findUserById(int id);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public abstract void updateUser(User user);

    /**
     * 批量删除信息
     * @param checkboxIds
     */
    public abstract void deleteSelectedUsers(String[] checkboxIds);

    /**
     * 分页查询以及条件查询
     * @param currentPage
     * @param rows
     * @param parameterMap
     * @return
     */
    public abstract PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> parameterMap);
}
