package com.xbsj.mapper;

import com.xbsj.entity.SysRole;
import com.xbsj.provider.RoleProvider;
import org.apache.ibatis.annotations.SelectProvider;

public interface RoleMapper {

    /**
     * 根据角色id查询角色信息
     */
    @SelectProvider(type = RoleProvider.class,method = "selectRoleById")
    SysRole selectRoleById(Integer id);
}
