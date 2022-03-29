package com.robin.dao;

import com.robin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
//    //select all users
//    List<User> getUserList();
//
//    List<User> getUserByLimit(Map<String, Integer> map);
//    //select one user
//    User getUserById(int id);
//
//    //insert one user
//    int addUser(User user);
//
//    //update one user
//    int updateUser(User user);
//
//    //deleteUser(User user)
//    int deleteUser(int id);
}
