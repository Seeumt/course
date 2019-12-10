package cn.ec.service.impl;

import cn.ec.dao.UserMapper;
import cn.ec.model.User;
import cn.ec.pojo.Params;
import cn.ec.repository.UserRepository;
import cn.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> findOne(String userSn) {
        User user = new User();
        user.setUserSn(userSn);
        Example<User> userExample = Example.of(user);
        List<User> users = userRepository.findAll(userExample);
        return users;
    }

    @Override
    public User selectByIdAndPid(Integer id, Integer pid) {
        return userMapper.selectByIdAndPid(id,pid);
    }

    @Override
    public User query(Map map) {
        return userMapper.query(map);
    }

    @Override
    public User queryByUser(User user) {
        return userMapper.queryByUser(user);
    }

    @Override
    public List<User> queryByIds(List<Integer> ids) {
        return userMapper.queryByIds(ids);
    }

    @Override
    public List<User> queryByUserIds(cn.ec.dto.User user) {
        return userMapper.queryByUserIds(user);
    }

    @Override
    public List<User> queryByArrayIds(Integer[] ids) {
        return userMapper.queryByArrayIds(ids);
    }

    @Override
    public List<User> selectByDepartmentSn(Params params) {
        return userMapper.selectByDepartmentSn(params);
    }

    @Override
    public List<User> selectByDepartmentSnOfMap(Map<String, Object> map) {
        return userMapper.selectByDepartmentSnOfMap(map);
    }


}

