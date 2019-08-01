package com.ctgu.dao;

import com.ctgu.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生类接口
 */
@Mapper
public interface StudentDao {

    List<Student> selectif(@Param("name") String name, @Param("age") int id);
}
