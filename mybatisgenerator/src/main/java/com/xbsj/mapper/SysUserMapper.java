package com.xbsj.mapper;

import com.xbsj.model.SysUser;
import com.xbsj.model.SysUserWithBLOBs;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserWithBLOBs record);

    int insertSelective(SysUserWithBLOBs record);

    SysUserWithBLOBs selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysUserWithBLOBs record);

    int updateByPrimaryKey(SysUser record);
}