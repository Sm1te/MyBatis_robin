package com.robin.dao.UserDaoTest;

import com.robin.dao.UserMapper;
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
        List<User> userList = mapper.getUserList();

        for(User user: userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
