package com.xbsj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SessionFacatoryUtil {

    private static SqlSessionFactory sessionFactory;

    private SessionFacatoryUtil(){}

    public static SqlSession getSession(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            if (sessionFactory == null){
                sessionFactory =new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory.openSession();
    }
}
