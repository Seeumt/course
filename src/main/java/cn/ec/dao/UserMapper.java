package cn.ec.dao;

import cn.ec.model.User;
import cn.ec.pojo.Params;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import java.util.List;
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

    List<User> queryByIds(List<Integer> ids);

    List<User> queryByUserIds(cn.ec.dto.User user);

    List<User> queryByArrayIds(Integer[] ids);

//    List<User> selectByDepartmentSn(String departmentSn);
//    List<User> selectByDepartmentSn(@Param("departmentSn") String departmentSn, @Param("count") Integer count);
    List<User> selectByDepartmentSn(Params params);

    List<User> selectByDepartmentSnOfMap(Map<String, Object> map);
}
