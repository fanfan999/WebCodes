package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用jdbc操作数据库
        String searchSql = "select * from user";
        List<User> user = template.query(searchSql, new BeanPropertyRowMapper<User>(User.class));

        return user;
    }

   @Override
   public User findUserByUserNameAndPassword(String username, String password) {
       try {
           String sql = "select * from user where username = ? and password = ?";
           User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
           return user;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }

   }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //执行sql
        template.update(sql,user.getName(),user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        Map<String, Object> userInfo = template.queryForMap(sql, id);
        User user = new User();

        //封装信息
        try {
            BeanUtils.populate(user, userInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(User user) {
        //注意语句不要写错了
        String sql = "update user set gender = ?, age = ?, address = ?" +
                ",qq = ?, email = ? where id = ?";
        //执行sql
        template.update(sql,user.getGender(),user.getAge(), user.getAddress(), user.getQq(),
                user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {
        //定义一个模板初始化sql
        String sql = "select count(*) from user where 1 = 1";

        StringBuilder builder = new StringBuilder();
        builder.append(sql);
        //遍历map,根据map的value是否有值,来拼接sql
        Set<String> keySet = parameterMap.keySet();
        //System.out.println("keySet.size(): " + keySet.size());
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
               continue;
            }
            System.out.println("key: " + key);
            //获取value,因为我们知道这个value只有一个值,所以这里可以直接取0
            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if (value != null && !value.equals("")){
                //有值,就拼接字符串: and name like `%?%`模糊查询
                builder.append(" and " + key + " like ?");
                //获取?条件的值
                params.add("%" + value + "%");
            }
        }
        sql = builder.toString();

        /*System.out.println("sql语句" + builder.toString());
        System.out.println("params集合" + params);*/
        int count = template.queryForObject(sql, Integer.class, params.toArray());
        //System.out.println("count: " + count);
        return count;
    }

    @Override
    public List findUserByPage(int start, int rows, Map<String, String[]> parameterMap) {
        String sql = "select * from user where 1 = 1";

        StringBuilder builder = new StringBuilder();
        builder.append(sql);
        //遍历map,根据map的value是否有值,来拼接sql
        Set<String> keySet = parameterMap.keySet();
        //System.out.println("keySet.size(): " + keySet.size());
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            System.out.println("key: " + key);
            //获取value,因为我们知道这个value只有一个值,所以这里可以直接取0
            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if (value != null && !value.equals("")){
                //有值,就拼接字符串: and name like `%?%`模糊查询
                builder.append(" and " + key + " like ?");
                //获取?条件的值
                params.add("%" + value + "%");
            }
        }
        //添加分页查询
        builder.append(" limit ?, ?");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        //System.out.println("--------------------");
        //System.out.println(params.toString());
        sql = builder.toString();
        //System.out.println(sql);
        //query当有多个对象的时候,返回的是一个list集合,而queryforobject只会返回一个对象
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
