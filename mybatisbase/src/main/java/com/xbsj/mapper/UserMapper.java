package com.xbsj.mapper;

import com.xbsj.entity.SysUser;

public interface UserMapper {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    SysUser selectUserById(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(SysUser user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(SysUser user);

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    int deleteUserById(Integer id);


}
