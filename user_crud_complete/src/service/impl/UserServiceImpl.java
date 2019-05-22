package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteSelectedUsers(String[] checkboxIds) {
        if (checkboxIds != null && checkboxIds.length > 0) {
            //通过id删除用户信息
            for (int i = 0; i < checkboxIds.length; i++) {
                int id = Integer.parseInt(checkboxIds[i]);
                userDao.deleteUserById(id);
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> parameterMap) {
        //创建一个pageBean对象
        PageBean<User> pageBean = new PageBean<User>();
        //设置参数
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //调用dao查询totalcount总记录数
        int totalCount = userDao.findTotalCount(parameterMap);
        //计算总页码
        int totalPage = ((totalCount % rows) == 0) ? (totalCount / rows) : ((totalCount / rows) + 1);
        //System.out.println("totalPage: "+ totalPage);
        //对currentPage作出判断,当它<=0时,令它等于1,当它>最大页码时,令它等于最大页码
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        //设置数据库中开始查找的索引
        int start = (currentPage - 1) * rows;
        //System.out.println("===" + start);
        if (start <= 1) {
            start = 0;
        }
        //调用dao查询指定范围索引的数据,返回一个list集合
        List list = userDao.findUserByPage(start, rows, parameterMap);
        //设置pageBean对象
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(list);
        pageBean.setTotalPage(totalPage);

        //System.out.println("pageBean: " + pageBean);
        return pageBean;
    }

}
