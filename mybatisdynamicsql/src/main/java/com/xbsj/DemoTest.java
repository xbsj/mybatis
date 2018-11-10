package com.xbsj;

import com.xbsj.entity.SysUser;
import com.xbsj.mapper.UserMapper;
import com.xbsj.util.SessionFacatoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    private SqlSession session;

    @Test
    public void selectByUser(){
        SysUser user = new SysUser();
        //user.setUserEmail("admin@mybatis");
        user.setUserName("u");

        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<SysUser> users = userMapper.selectByUser(user);
        for (SysUser item:users ) {
            System.out.println(item);
        }
    }

    @Test
    public void seletByIdOrUserName(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        SysUser user = userMapper.seletByIdOrUserName(1, null);
        System.out.println(user);
    }

    @Test
    public void selectByUserNameAndUserEmail(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        SysUser user = userMapper.selectByUserNameAndUserEmail("u", "wangwu@mybatis");
        System.out.println(user);
    }

    @Test
    public void updateUserById(){
        SysUser user = new SysUser();
        user.setUserId(7);
        user.setUserName("wangwu");
        user.setHeadImg(new byte[]{1,2,3,4,5,6});
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int count = userMapper.updateUserById(user);
        System.out.println(count);
    }

    @Test
    public void selectByIdList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(10);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<SysUser> users = userMapper.selectByIdList(list);
        for (SysUser user: users ) {
            System.out.println(user);
        }
    }
    @Before
    public void before(){
        session = SessionFacatoryUtil.getSession();
    }

    @After
    public void after(){
        session.commit();
        session.close();
    }

}
