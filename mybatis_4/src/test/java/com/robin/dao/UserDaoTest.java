package com.robin.dao;

import com.robin.pojo.User;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void selectUser() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUserList();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map  = new HashMap<>();
        map.put("startIndex", 0);
        map.put("endIndex", 2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(3);
        logger.info("wuhu");
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int alex = mapper.addUser(new User(4, "alex", "1234567890"));
        sqlSession.commit();
        test1();
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
        test1();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(3);
        System.out.println(i);
        sqlSession.commit();
        test1();
        sqlSession.close();
    }
}
