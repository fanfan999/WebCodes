package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的dao
 */
public interface UserDao {
    public abstract List<User> findAll();

    public abstract User findUserByUserNameAndPassword(String username, String password);

    public abstract void addUser(User user);

    public abstract void deleteUserById(int id);

    public abstract User findUserById(int id);

    public abstract void updateUser(User user);

    public abstract int findTotalCount(Map<String, String[]> parameterMap);

    public abstract List findUserByPage(int start, int end, Map<String, String[]> parameterMap);
}
