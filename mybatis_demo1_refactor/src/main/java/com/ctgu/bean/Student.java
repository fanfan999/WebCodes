package com.ctgu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体类
 *
 * 使用lombok记得要去插件库下载插件然后重启
 */
@Data
@NoArgsConstructor
public class Student {

    private int id;

    private String name;

    private int age;

    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
