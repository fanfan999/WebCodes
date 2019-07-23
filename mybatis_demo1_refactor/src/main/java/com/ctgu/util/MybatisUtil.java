package com.ctgu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis操作数据库的工具类
 */
public class MybatisUtil {

    //SqlSessionFactory是线程安全的,所以可以创建一个对象就可以了
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSession getSqlSession() {
        InputStream input = null;

        SqlSession sqlSession = null;

        try {

            if (sqlSessionFactory == null) {
                input = Resources.getResourceAsStream("mybatis.xml");

                //DCL双重检验锁
                synchronized (MybatisUtil.class) {
                    if (sqlSessionFactory == null) {
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory.openSession(true);
    }
}
