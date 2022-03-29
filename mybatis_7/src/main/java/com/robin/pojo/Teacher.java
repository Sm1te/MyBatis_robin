package com.robin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // Introduce parameterless construction 、get、set、toString Other methods
@AllArgsConstructor // The parametric construction method is introduced
@NoArgsConstructor // Introduce the parameterless construction method
public class Teacher {

    private int id; // 教师编号
    private String name; // 教师姓名
    // 一个老师拥有多个学生, 使用泛型为Student的List集合来实现一对多
    private List<Student> students;

}
