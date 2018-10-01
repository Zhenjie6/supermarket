package com.hngd.data.mapper;

import com.hngd.data.bean.User;

import java.util.List;

public interface UserMapper {
    //查找所有用户
    List<User> findAllUsers();

    //根据用户ID查询信息
    User findUserById(int id);

    //根据用户名查找登录信息
    User findLgInfoByName (String name);

    //根据用户名进行模糊查询
    List<User> findUserByName(String name);

    //添加用户
    boolean insertUser(User user);

    //根据Id修改用户信息
    boolean updateUserById(User user);

    //根据Id删除用户
    boolean deleteUserById(int id);

    //根据Id修改密码
    boolean updatePwdById(User user);
}
