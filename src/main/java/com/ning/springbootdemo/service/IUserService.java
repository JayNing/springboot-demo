package com.ning.springbootdemo.service;

import com.ning.springbootdemo.entity.User;

public interface IUserService {
    void insertUser(User user);

    User searchById(Integer id);
}