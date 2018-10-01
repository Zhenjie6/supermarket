package com.hngd.data.dao;

import com.hngd.data.bean.User;

import java.util.List;

public interface IUserDao {
    User findUserById(int id);

    User findLgInfoByName (String name);

    List<User> findUsersByName(String name);

    List<User> findAllUsers();

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean delUserById(int id);

    boolean updatePwdById(User user);
}
