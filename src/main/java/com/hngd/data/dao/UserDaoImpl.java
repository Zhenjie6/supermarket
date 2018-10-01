package com.hngd.data.dao;

import com.hngd.data.bean.User;
import com.hngd.data.mapper.UserMapper;
import com.hngd.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    SqlSession sqlSession = null;
    UserMapper mapper = null;
    private void init(){
        sqlSession = MyBatisHelper.getSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 查找所有用户
     * @return 用户
     */
    @Override
    public List<User> findAllUsers() {
         init();
         List<User> userList = mapper.findAllUsers();
         MyBatisHelper.closeSession(sqlSession);
         return userList;
    }

    @Override
    public List<User> findUsersByName(String name) {
        return null;
    }

    /**
     * 根据Id查找相关用户信息
     * @param id	指定id
     * @return	user对象
     */
    public User findUserById(int id) {
        init();
        User user = mapper.findUserById(id);
        sqlSession.close();
        return user;
    }

    /**
     * 根据用户名进行用户信息模糊查询
     * @param name	指定用户名
     * @return	list对象
     */
    public List<User> findUserByName(String name) {
        init();
        List<User> list = mapper.findUserByName("%" + name + "%");
        sqlSession.close();
        return list;
    }


    /**
     * 添加用户
     * @param user User对象
     * @return	返回插入结果，成功true，失败false
     */
    public boolean insertUser(User user) {
        init();
        boolean result = mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    /**
     * 修改用户信息
     * @param user	User对象
     * @return 修改结果，成功则true，失败则false
     */
    public boolean updateUser(User user) {
        init();
        boolean result = mapper.updateUserById(user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    /**
     * 根据id删除指定用户
     * @param id
     * @return 删除结果。成功true，失败false。
     */
    public boolean delUserById(int id) {
        init();
        boolean result = mapper.deleteUserById(id);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public User findLgInfoByName(String name) {
        init();
        User user = mapper.findLgInfoByName(name);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public boolean updatePwdById(User user) {
        init();
        boolean result = mapper.updatePwdById(user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
