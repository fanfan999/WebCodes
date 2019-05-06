package jdbctemplate;

import ConnectionPool.druid.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

/**
 * JdbcTemplate演示案例
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        //定义一个sql语句
        String sql = "update product set price = ? where id = ?";
        //赋值

        //调用方法
        int count = template.update(sql, 500, 11);
        //不需要释放资源,不需要归还,系统都会帮我们完成.
        System.out.println(count);
    }
}
