package com.robin.dao;

import com.robin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //select all users
    List<User> getUserList();

    List<User> getUserByLimit(Map<String, Integer> map);
    //select one user
    User getUserById(int id);

    //insert one user
    int addUser(User user);

    //update one user
    int updateUser(User user);

    //deleteUser(User user)
    int deleteUser(int id);
}
