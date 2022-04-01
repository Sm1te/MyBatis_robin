package com.robin.dao;

import com.robin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //根据id查询用户
    User queryUserById(@Param("id") int id);
}
