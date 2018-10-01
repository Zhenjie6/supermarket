package com.hngd.web.supermarket.service;

import com.hngd.data.bean.User;

import java.util.HashMap;
import java.util.List;

public interface IUserService {
    List<HashMap<String,String>> getUserList();

    User findUserById(int id);

    List<User> findUserByName (String name);

    User findLgInfoByName (String name);

    boolean insertUser (User user);

    boolean updateUser (User user);

    boolean delUserById(int id);

    boolean updatePwdById(User user);
}
