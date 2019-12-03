package cn.ec.service;

import cn.ec.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    User getUserById(Integer id);

    Optional<User> findById(Integer id);

    List<User> findOne(String userSn);

    User selectByIdAndPid(Integer id, Integer pid);

    User query(Map map);

    User queryByUser(User user);

    List<User> queryByIds(List<Integer> ids);

    List<User> queryByUserIds(cn.ec.dto.User user);

    List<User> queryByArrayIds(Integer[] ids);
}
