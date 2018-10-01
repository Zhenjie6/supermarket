package com.hngd.web.supermarket.service.impl;

import com.hngd.data.bean.User;
import com.hngd.data.dao.UserDaoImpl;
import com.hngd.web.supermarket.service.IUserService;
import com.hngd.util.FormatUtil;


import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements IUserService {
    UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 获取全部用户
     * @return 返回List<HashMap<String,String>类型的用户表
     */
    @Override
    public List<HashMap<String, String>> getUserList() {
        List<HashMap<String,String>> list;
        list = FormatUtil.userToHashMap(userDao.findAllUsers());
        return list;
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUserById(int id) {
        User user = userDao.findUserById(id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean delUserById(int id) {
        return userDao.delUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public boolean updatePwdById(User user) {
        return userDao.updatePwdById(user);
    }

    @Override
    public User findLgInfoByName(String name) {
        return userDao.findLgInfoByName(name);
    }
}

