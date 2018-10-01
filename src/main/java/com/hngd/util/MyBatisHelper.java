package com.hngd.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisHelper {
    static SqlSessionFactory sqlSessionFactory;
    static{
        String resource = "mybatis_config.xml";
        InputStream inputStream;
        try{
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static public SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

    static public void closeSession(SqlSession sqlSession){
        sqlSession.close();
    }
}
