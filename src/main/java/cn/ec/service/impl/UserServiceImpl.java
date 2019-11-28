package cn.ec.service.impl;

import cn.ec.dao.UserMapper;
import cn.ec.model.User;
import cn.ec.repository.UserRepository;
import cn.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
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



}
