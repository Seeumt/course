package cn.ec.dao;

import cn.ec.model.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {
//    @Select("select * from user where id=#{id}")
//    @Results({
//            @Result(column = "user_sn",property = "userSn"),
//            @Result(column = "user_name",property = "userName"),
//            @Result(column = "mobile_number",property = "mobileNumber"),
//            @Result(column = "last_password_reset_date",property = "lastPasswordResetDate")
//    })
    User getUserById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByIdAndPid(@Param("idd") Integer id,@Param("pdd") Integer pid);

    User query(Map map);

    User queryByUser(User user);
}
