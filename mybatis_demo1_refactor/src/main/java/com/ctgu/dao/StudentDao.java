package com.ctgu.dao;

import com.ctgu.bean.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 学生类接口
 */
public interface StudentDao {

    void insertStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(Student student);

    ArrayList<Student> selectAllStudent();

    Student selectOneStudent(int id);
}
