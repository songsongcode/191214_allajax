package com.dream.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    private static SqlSessionFactory sessionFactory = null;
    static{
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}
