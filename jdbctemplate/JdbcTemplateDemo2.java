package jdbctemplate;

import ConnectionPool.druid.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 完成需求并测试
 */
public class JdbcTemplateDemo2 {

    //为了不用在每一个方法里都获取jdbctemplate对象,我们就把这个放在成员变量位置
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    //Junit单元测试,可以让方法独立执行,怎么让方法独立执行呢,
    // 在方法上加一个注解就可以了@Test,然后点击将Junit添加到路径就可以了
    // 此时就不需要主方法也可以执行方法了,例如下面代码.
    /*@Test
    public void test() {
        System.out.println("这是Junit的测试方法");
    }*/

    //test1完成需求1:将`平板1`的价格`price`修改为`1000`元.
    @Test
    public void test1() {
        //定义sql
        String sql = "update product set price = ? where id = ?";
        int count = template.update(sql, 1000, 11);
        System.out.println(count);
    }

    //test2完成需求2:添加一条记录.
    @Test
    public void test2() {
        //定义sql
        String sql = "insert into product values (null ,?,?)";
        int count = template.update(sql, "水杯", 660);
        System.out.println(count);
    }
    //test3完成需求3:删除刚才添加的记录.
    @Test
    public void test3() {
        //定义sql
        String sql = "delete from product where name = ? and price = ?";
        int count = template.update(sql, "水杯", 660);
        System.out.println(count);
    }
    //test4完成需求4:查询`id为1`的记录,将其封装为Map集合..
    @Test
    public void test4() {
        //定义Map集合
        Map map = new HashMap();
        //定义sql
        String sql = "select * from product where id = ?";
        map = template.queryForMap(sql, 1);
        System.out.println(map);
    }
    //test5完成需求5:查询所有的记录,将其封装为Map集合.
    // 结果报错,表明只能一条记录封装唯一Map集合
    @Test
    public void test5() {
        //定义Map集合
        Map<String, Object> map = new HashMap<>();
        //定义sql
        String sql = "select * from product";
        map = template.queryForMap(sql);
        System.out.println(map);
    }
    //test6完成需求6:查询所有的记录,将其封装为List集合.
    @Test
    public void test6() {
        //定义List集合
        List list = new ArrayList();
        //定义sql
        String sql = "select * from product";
        //执行sql
        list = template.queryForList(sql);
        System.out.println(list);
    }
    //test7完成需求7:查询所有的记录,将其封装为product对象的List集合
    /*@Test
    public void test7() {
        //定义List集合
        List list = new ArrayList();
        //定义sql
        String sql = "select * from product";
        //执行sql
        list = template.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = null;
                product = new Product();
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                product.setName(name);
                product.setPrice(price);
                return product;
            }
        });
        System.out.println(list);
    }*/
    //test7改进版
    @Test
    public void test7() {
        //定义List集合
        List<Product> list = new ArrayList<>();
        //定义sql
        String sql = "select * from product";
        //执行sql
        //使用已经定义好的方法,但是这个有个问题,你的字段不能有null,有null就会报错
        // 此时我们可以将product类中的变量都定义为引用类型,因为引用类型有默认值.
        list = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        System.out.println(list);
    }
    //test8完成需求8:查询总记录数.
    @Test
    public void test8() {
        //定义sql
        String sql = "select count(id) from product";
        //执行sql,注意queryForObject返回值是long类型
        Long count = template.queryForObject(sql, long.class);
        System.out.println(count);
    }
}
