package com.ctgu;

import com.ctgu.bean.Student;
import com.ctgu.dao.StudentDao;
import com.ctgu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Studentdemo3Test {
    //创建接口对象
    private StudentDao studentDao;

    //获取sqlSession对象
    private SqlSession sqlSession;

    /*
    创建studentDao和sqlSession对象
     */
    @Before //表示运行测试方法之前会先执行该注解的内容
    public void initDao() {
        sqlSession = MybatisUtil.getSqlSession();

        //由mybatis创建动态代理对象,括号中的参数为被代理的接口对象
        //没有这条语句的话,接口对象是没有实例化的,是空的,肯定会报错的
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    /**
     * 使用结束后关闭sqlSession
     */
    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectif() {
        List<Student> list = studentDao.selectif("", 10);
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
