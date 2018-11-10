package com.xbsj.mapper;

import com.xbsj.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<SysUser> selectByUser(SysUser user);

    /**
     * 根据用户id或用户名查询用户信息
     *
     * @param id
     * @param userName
     * @return
     */
    SysUser seletByIdOrUserName(@Param("id") Integer id, @Param("userName") String userName);

    /**
     * 根据用户名和邮箱查询用户信息
     *
     * @param userName
     * @param userEmail
     * @return
     */
    SysUser selectByUserNameAndUserEmail(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    int updateUserById(SysUser user);

    /**
     *多id查询
     * @param ids
     * @return
     */
    List<SysUser> selectByIdList(List<Integer> ids);


}
