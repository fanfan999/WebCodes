package com.ctgu;

import com.ctgu.bean.Student;
import com.ctgu.dao.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.ArrayList;

/**
 * student的测试类
 */
public class StudentTest01 {

    private StudentDaoImpl studentDao = new StudentDaoImpl();

    @Test
    public void deleteStudent() {
        studentDao.deleteStudent(26);
        System.out.println("删除成功!");
    }

    @Test
    public void insertStudent() {
        Student student = new Student("学生1", 18, "武汉");

        System.out.println("插入前!" + student);
        studentDao.insertStudent(student);
        System.out.println("插入成功!" + student);

    }

    @Test
    public void updateStudent() {
        Student student = new Student(27,"学生2", 20);

        studentDao.updateStudent(student);
        System.out.println("修改成功");
    }

    @Test
    public void selectAllStudent() {
        ArrayList<Student> students = studentDao.selectAllStudent();

        for (Student s : students) {
            System.out.println(s);
        }

    }

    @Test
    public void selectOneStudent() {
        Student student = studentDao.selectOneStudent(27);

        System.out.println(student);

    }
}
