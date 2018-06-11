package com.ning.springbootdemo.service.impl;

import com.ning.springbootdemo.entity.User;
import com.ning.springbootdemo.exception.UserException;
import com.ning.springbootdemo.mapper.UserMapper;
import com.ning.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertUser(User user) {
        throw UserException.TEST;
//        userMapper.insertSelective(user);
    }

    @Override
    public User searchById(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }
}