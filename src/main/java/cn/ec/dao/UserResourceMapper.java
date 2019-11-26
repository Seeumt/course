package cn.ec.dao;

import cn.ec.model.UserResource;

public interface UserResourceMapper {
    int insert(UserResource record);

    int insertSelective(UserResource record);
}