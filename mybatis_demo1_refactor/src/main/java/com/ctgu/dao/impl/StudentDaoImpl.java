package com.ctgu.dao.impl;

import com.ctgu.bean.Student;
import com.ctgu.dao.StudentDao;
import com.ctgu.util.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生dao层的实现类
 */
public class StudentDaoImpl implements StudentDao {

    /**
     * 添加学生
     *
     * @param student 添加的学生对象
     */
    @Override
    public void insertStudent(Student student) {
        //SqlSession继承了autocloseable接口,可以使用jdk7的新特性自动关闭
        try (SqlSession sqlSession = MybatisUtil.getSqlSession();) {
            sqlSession.insert("insertStudent", student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(int id) {

        try (SqlSession sqlSession = MybatisUtil.getSqlSession();) {
            //执行删除
            sqlSession.delete("deleteStudent", id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent(Student student) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession();) {
            //执行更新
            sqlSession.update("updateStudent", student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> selectAllStudent() {
        List<Student> list = null;

        try (SqlSession sqlSession = MybatisUtil.getSqlSession();) {
            //执行查询,并返回list
            list = sqlSession.selectList("selectAllStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<Student>) list;
    }

    @Override
    public Student selectOneStudent(int id) {
        Student student = null;

        try (SqlSession sqlSession = MybatisUtil.getSqlSession();) {
            //执行查询
            student = sqlSession.selectOne("selectOneStudent", id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
