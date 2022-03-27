package com.robin.dao;

import com.robin.pojo.User;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(3);
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int alex = mapper.addUser(new User(4, "alex", "1234567890"));
        sqlSession.commit();
        test();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        //user.setPwd("991214");
        int i = mapper.updateUser(user);
        System.out.println(i);
        sqlSession.commit();
        test();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(3);
        System.out.println(i);
        sqlSession.commit();
        test();
        sqlSession.close();
    }
}
