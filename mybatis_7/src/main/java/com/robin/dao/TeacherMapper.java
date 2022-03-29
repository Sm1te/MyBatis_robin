package com.robin.dao;

import com.robin.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    // 获取所有老师信息
    List<Teacher> getTeacher();
}
