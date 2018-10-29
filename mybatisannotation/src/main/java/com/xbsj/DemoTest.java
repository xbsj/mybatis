package com.xbsj;

import com.xbsj.entity.SysRole;
import com.xbsj.entity.SysUser;
import com.xbsj.mapper.RoleMapper;
import com.xbsj.mapper.UserMapper;
import com.xbsj.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DemoTest {

    private SqlSession session;

    /**
     * 根据用户id获取用户信息
     */
    @Test
    public void selectUserById(){
        //加载对应Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        SysUser user = userMapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserAll(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<SysUser> users = userMapper.selectUserAll();
        for (SysUser user : users){
            System.out.println(user);
        }
    }

    /**
     * 增加用户
     */
    @Test
    public void inserUser(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        SysUser user = new SysUser("xiangyu", "123456", "xiangyu@163.com", "测试用户", new byte[]{1, 2, 3, 4}, new Date());
        int count = userMapper.insertUser(user);
        System.out.println(user.getUserId());
    }

    /**
     * 修改用户信息
     */
    @Test
    public void updateUserInfo(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setUserId(11);
        user.setUserEmail("xiangyu@163.com");
        user.setUserInfo("测试用户");
        int count = userMapper.updateUserInfo(user);
        System.out.println(count);
    }



    /**
     * 根据用户id删除用户
     */
    @Test
    public void deleteUserById(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int count = userMapper.deleteUserById(13);
        System.out.println(count);

    }


    /**
     * 根据角色id查询角色信息
     */
    @Test
    public void selectRoleById(){
        RoleMapper roleMapper = session.getMapper(RoleMapper.class);
        SysRole role = roleMapper.selectRoleById(1);
        System.out.println(role);
    }



    @Before
    public void before(){
        session = SessionFactoryUtil.getSession();
    }

    @After
    public void after(){
        session.commit();
        session.close();
    }

}
