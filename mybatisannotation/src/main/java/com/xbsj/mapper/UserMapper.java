package com.xbsj.mapper;

import com.xbsj.entity.SysUser;
import org.apache.ibatis.annotations.*;

import javax.xml.ws.WebServiceRef;
import java.util.List;

public interface UserMapper {

    @Results(id = "userResultMap",value = {
            /*
            * id=true 对应<id>
            * */
            @Result(property = "userId",column = "user_id",id = true),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "userInfo",column = "user_info"),
            @Result(property = "headImg",column = "head_img"),
            @Result(property = "createTime",column = "create_time")
    })

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Select({"select user_id,user_name,user_password,user_info,user_email,head_img,create_time from sys_user where user_id = #{id}"})
    SysUser selectUserById(Integer id);



    @ResultMap("userResultMap")
    @Select({"select user_id,user_name,user_password,user_info,user_email,head_img,create_time from sys_user"})
    List<SysUser> selectUserAll();


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    /*@Insert({"insert into sys_user(user_name,user_password,user_email,user_info ,head_img,create_time) values(#{userName},#{userPassword},#{userEmail},#{userInfo},#{headImg},#{createTime})"})
    @Options(useGeneratedKeys = true,keyProperty = "userId") //返回自增主键
    int insertUser(SysUser user);*/

    /**
     * 返回非自增主键
     * SelectKey 相当于
     * <selectKey keyColumn="user_id" resultType="Integer" keyProperty="userId" order="AFTER">
     *      SELECT LAST_INSERT_ID()
     * </selectKey>
     * before 相当于 order
     *      false = AFTER
     *      true = BEFORE
     * @param user
     * @return
     */
    @Insert({"insert into sys_user(user_name,user_password,user_email,user_info ,head_img,create_time) values(#{userName},#{userPassword},#{userEmail},#{userInfo},#{headImg},#{createTime})"})
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty = "userId",resultType = Integer.class,before = false)
    int insertUser(SysUser user);



    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Update({"update sys_user set user_email = #{userEmail},user_info = #{userInfo} where user_id = #{userId}"})
    int updateUserInfo(SysUser user);

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @Delete({"delete from sys_user where user_id = #{id}"})
    int deleteUserById(Integer id);


}
