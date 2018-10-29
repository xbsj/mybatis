package com.xbsj.provider;

import org.apache.ibatis.jdbc.SQL;

public class RoleProvider {

    public String   selectRoleById(Integer id){
        return new SQL(){
            {
                SELECT("role_id,role_name,enabled,create_by,create_time");
                FROM("sys_role");
                WHERE("role_id = #{id}");
            }
        }.toString();
    }
}
