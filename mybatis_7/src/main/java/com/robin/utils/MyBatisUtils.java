package com.robin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/** * SqlSessionFactoryBuilder( Build a factory ) * --> sqlSessionFactory( production sqlSession) * --> sqlSession */
public class MyBatisUtils {

    // Get static SQL Conversational factory
    private static SqlSessionFactory sqlSessionFactory;
    // Static method body
    static {

        try {

// Read configuration file
            String resource = "mybatis-config.xml";
// Parsing configuration file stream
            InputStream inputStream = Resources.getResourceAsStream(resource);
// Get factory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    /** * SqlSession Provides execution in the database SQL All methods required for the command */
    public static SqlSession getSqlSession() {

// Set the parameter to true, Realize automatic submission
        return sqlSessionFactory.openSession(true);
    }
}