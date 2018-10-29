package com.xbsj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SessionFactoryUtil {

    private static SqlSessionFactory factory; //创建SqlSessionFactory

    private SessionFactoryUtil(){}

    public static SqlSession getSession(){
        try {
            //读取mybatis的核心配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            if (factory == null){
                factory =new  SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory.openSession();
    }
}
