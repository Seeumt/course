package cn.ec.dao;

import cn.ec.model.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);
}
